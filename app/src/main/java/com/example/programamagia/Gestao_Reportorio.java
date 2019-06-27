package com.example.programamagia;

import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.programamagia.Adapter.Adapter_Edittxt;
import com.example.programamagia.BD.BaseDados;
import com.example.programamagia.Comandos_SQL.Capitulos_SQL;
import com.example.programamagia.Comandos_SQL.Entidades.Capitulo;
import com.example.programamagia.Comandos_SQL.Entidades.Sub_Capitulo;
import com.example.programamagia.Comandos_SQL.Entidades.Truque;
import com.example.programamagia.Comandos_SQL.Entidades.Valor;
import com.example.programamagia.Comandos_SQL.Sub_Capitulos_SQL;
import com.example.programamagia.Comandos_SQL.Truques_SQL;
import com.example.programamagia.Comandos_SQL.Valores_SQL;

import java.util.ArrayList;

public class Gestao_Reportorio extends AppCompatActivity {
    private BaseDados BD;
    private Button btn_ins;
    private SQLiteDatabase connection;
    private Sub_Capitulos_SQL SQL_Sub_Capitulo;
    private Capitulos_SQL SQL_Capitulo;
    private Valores_SQL SQL_Valores;
    private Truques_SQL SQL_Truques;
    private ListView lista_valor, listView, listView1, lista_valor_ver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestao_truques);
        BD = new BaseDados(this);
        connection = BD.getWritableDatabase();
        SQL_Sub_Capitulo = new Sub_Capitulos_SQL(connection);
        SQL_Capitulo = new Capitulos_SQL(connection);
        SQL_Valores = new Valores_SQL(connection);
        SQL_Truques = new Truques_SQL(connection);

        lista_valor_ver = findViewById(R.id.lista_valor_ver);
        lista_valor_ver.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Valor valor = (Valor) lista_valor_ver.getItemAtPosition(position);
                longclick_event(position,valor.getId_Valores());
                return false;
            }
        });

        listView = findViewById(R.id.lista_teste);
        listView.setAdapter(SQL_Capitulo.Listar_Capitulos(this,android.R.layout.simple_list_item_multiple_choice));
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                SparseBooleanArray pos = listView.getCheckedItemPositions();
                ArrayList<Integer> pos_f = new ArrayList<>();
                for (int i =0;i<pos.size();i++){
                    if (pos.valueAt(i)==true)
                        pos_f.add(((Capitulo)listView.getItemAtPosition(pos.keyAt(i))).getId_Cap());
                }
                ArrayAdapter<Sub_Capitulo> aaa= SQL_Sub_Capitulo.Listar_Sub_Capitulos(Gestao_Reportorio.this,0,android.R.layout.simple_list_item_multiple_choice);
                ArrayAdapter<Sub_Capitulo> sel_sub_por_caps=new ArrayAdapter<Sub_Capitulo>(Gestao_Reportorio.this,android.R.layout.simple_list_item_multiple_choice);
                for (int i =0;i<aaa.getCount();i++){
                    int id_cap = aaa.getItem(i).getId_Cap();
                    for (int j=0; j<pos_f.size();j++){
                        if (id_cap==pos_f.get(j)){
                            sel_sub_por_caps.add(aaa.getItem(i));
                        }
                    }
                }

                listView1.setAdapter(sel_sub_por_caps);

            }
        });

        listView1 = findViewById(R.id.lista_teste2);
        listView1.setAdapter(SQL_Sub_Capitulo.Listar_Sub_Capitulos(this,0,android.R.layout.simple_list_item_multiple_choice));
        listView1.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);



        ListView listView2 = findViewById(R.id.lista_valor_ver);
        listView2.setAdapter(SQL_Valores.Listar_Valores(this));

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                try {
                    SparseBooleanArray pos = listView1.getCheckedItemPositions();
                    ArrayList<Sub_Capitulo> pos_f = new ArrayList<>();
                    for (int i = 0; i < pos.size(); i++) {
                        if (pos.valueAt(i) == true)
                            pos_f.add(((Sub_Capitulo) listView1.getItemAtPosition(pos.keyAt(i))));

                    }

                    lista_valor = findViewById(R.id.lista_valor);

                    final Adapter_Edittxt adapter_edittxt = new Adapter_Edittxt(Gestao_Reportorio.this, pos_f);
                    lista_valor.setAdapter(adapter_edittxt);
                }catch (Exception e){};
            }
        });



        btn_ins = findViewById(R.id.button_ins);

    }
    public void onClick_teste(View v) {
        try {
            final Adapter_Edittxt adapter_edittxt = (Adapter_Edittxt) lista_valor.getAdapter();
            ArrayList<Sub_Capitulo> pos_f = new ArrayList<>();
            pos_f = adapter_edittxt.getEditModelArrayList();
            for (int i = 0; i < listView1.getCheckedItemPositions().size(); i++) {
                Valor valor = new Valor();

                //No Adapter Edittxt usa-se as Obs para guardar o Valor
                valor.setValor(pos_f.get(i).getObs());
                valor.setSub_Cap(pos_f.get(i));
                valor.setTruque(SQL_Truques.Truque_by_Id(1));
                SQL_Valores.Inserir(valor);
            }
            Toast.makeText(this, "Inserido", Toast.LENGTH_LONG).show();
            lista_valor_ver.setAdapter(SQL_Valores.Listar_Valores(this));
        }catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
    public void longclick_event(final int pos, final int id_valor) {
        /*try{
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Deseja Eliminar?")
                    .setNegativeButton("Nao", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    })
                    .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            try{
                                SQL_Valores.Apagar(id_valor);
                                Toast.makeText(Gestao_Reportorio.this,"Eliminado",Toast.LENGTH_LONG).show();
                                lista_valor_ver.setAdapter(SQL_Valores.Listar_Valores(Gestao_Reportorio.this));
                            }catch (Exception e){
                                Toast.makeText(Gestao_Reportorio.this, e.getMessage(), Toast.LENGTH_LONG).show();
                                }
                        }
                    });
            builder.show();
        }catch (Exception e)

        {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }*/
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setPositiveButton("Editar", null);
            builder.setNegativeButton("Eliminar", null);

            final EditText input = new EditText(Gestao_Reportorio.this);
            final TextView msg_eliminar = new TextView(Gestao_Reportorio.this);
            input.setVisibility(View.INVISIBLE);
            builder.setView(input);
            msg_eliminar.setText("Deseja eliminar?");
            //builder.setView(msg_eliminar);

            final AlertDialog dialog = builder.create();
            dialog.show();

            final Button edit_btn = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
            final Button del_btn = dialog.getButton(AlertDialog.BUTTON_NEGATIVE);

            edit_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Button btn = (Button) v;
                    if (btn.getText().toString() == "Ok") {
                        Valor valor = new Valor();
                        valor.setValor(input.getText().toString());
                        valor.setId_Valores(((Valor) lista_valor_ver.getItemAtPosition(pos)).getId_Valores());
                        SQL_Valores.Editar(valor);
                        Toast.makeText(Gestao_Reportorio.this, "Atualizado", Toast.LENGTH_LONG).show();
                        lista_valor_ver.setAdapter(SQL_Valores.Listar_Valores(Gestao_Reportorio.this));
                        dialog.dismiss();
                    } else if (btn.getText().toString() == "Editar") {
                        input.setVisibility(View.VISIBLE);
                        input.setText(((Valor) lista_valor_ver.getItemAtPosition(pos)).getValor());
                        btn.setText("Ok");
                        del_btn.setVisibility(View.INVISIBLE);
                    } else if (btn.getText().toString() == "Não") {
                        btn.setText("Editar");
                        del_btn.setText("Eliminar");
                        msg_eliminar.setVisibility(View.INVISIBLE);
                    }

                }
            });

            del_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Button btn = (Button) v;
                    if (btn.getText().toString() == "Sim") {
                        SQL_Valores.Apagar(id_valor);
                        Toast.makeText(Gestao_Reportorio.this, "Eliminado", Toast.LENGTH_LONG).show();
                        lista_valor_ver.setAdapter(SQL_Valores.Listar_Valores(Gestao_Reportorio.this));
                        dialog.dismiss();
                    } else if (btn.getText().toString() == "Eliminar") {
                        msg_eliminar.setVisibility(View.VISIBLE);
                        btn.setText("Sim");
                        edit_btn.setText("Não");
                    }

                }
            });

        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}
