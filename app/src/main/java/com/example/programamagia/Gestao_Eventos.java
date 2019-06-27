package com.example.programamagia;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.programamagia.BD.BaseDados;
import com.example.programamagia.Comandos_SQL.Capitulos_SQL;
import com.example.programamagia.Comandos_SQL.Entidades.Capitulo;

public class Gestao_Eventos extends AppCompatActivity {

    private TextView textView_nomecap;
    private EditText editText_nomecap;
    private Button button_addcap;
    private ListView listview_cap;
    private BaseDados BD;
    private SQLiteDatabase connection;
    private Capitulos_SQL SQL_Capitulo;
    private ArrayAdapter<Capitulo> List_cap;
    private int posicao_click;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestao_eventos);
        try {

            BD = new BaseDados(this);
            connection = BD.getWritableDatabase();
            SQL_Capitulo = new Capitulos_SQL(connection);

            textView_nomecap = (TextView) findViewById(R.id.textView_nomecap);
            editText_nomecap = (EditText) findViewById(R.id.editText_nomecap);
            button_addcap = (Button) findViewById(R.id.button_addcap);
            listview_cap = (ListView) findViewById(R.id.listview_capitulos);


            listview_cap.setAdapter(SQL_Capitulo.Listar_Capitulos(this,android.R.layout.simple_list_item_1));


            listview_cap.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                    int b = ((Capitulo) listview_cap.getItemAtPosition(position)).getId_Cap() ;
                    longclick_event(position, b);
                    posicao_click = position;
                    return true;
                }
            });

        }catch (Exception e)

        {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
}


    public void longclick_event(final int pos, final int id_cap) {
        try{
           AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setPositiveButton("Editar",null);
            builder.setNegativeButton("Eliminar", null);

            final EditText input = new EditText(Gestao_Eventos.this);
            final TextView msg_eliminar = new TextView(Gestao_Eventos.this);
            input.setVisibility(View.INVISIBLE);
            builder.setView(input);
            msg_eliminar.setText("Deseja eliminar?");
            //builder.setView(msg_eliminar);

            final AlertDialog dialog = builder.create();
            dialog.show();

            final Button edit_btn = dialog.getButton(AlertDialog.BUTTON_POSITIVE );
            final Button del_btn = dialog.getButton(AlertDialog.BUTTON_NEGATIVE);

            edit_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Button btn = (Button) v;
                    if(btn.getText().toString()=="Ok"){
                       Capitulo capitulo = new Capitulo();
                       capitulo.setNome(input.getText().toString());
                       capitulo.setId_Cap(((Capitulo) listview_cap.getItemAtPosition(posicao_click)).getId_Cap());
                        SQL_Capitulo.Editar(capitulo);
                        Toast.makeText(Gestao_Eventos.this,"Atualizado",Toast.LENGTH_LONG).show();
                        listview_cap.setAdapter(SQL_Capitulo.Listar_Capitulos(Gestao_Eventos.this,android.R.layout.simple_list_item_1));
                        dialog.dismiss();
                    }
                    else if(btn.getText().toString()=="Editar") {
                        input.setVisibility(View.VISIBLE);
                        input.setText(((Capitulo) listview_cap.getItemAtPosition(posicao_click)).getNome());
                        btn.setText("Ok");
                        del_btn.setVisibility(View.INVISIBLE);
                    }
                    else if(btn.getText().toString()=="Não"){
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
                    if(btn.getText().toString()=="Sim") {
                        SQL_Capitulo.Apagar(id_cap);
                        Toast.makeText(Gestao_Eventos.this, "Eliminado", Toast.LENGTH_LONG).show();
                        listview_cap.setAdapter(SQL_Capitulo.Listar_Capitulos(Gestao_Eventos.this,android.R.layout.simple_list_item_1));
                        dialog.dismiss();
                    }

                    else if(btn.getText().toString()=="Eliminar") {
                        msg_eliminar.setVisibility(View.VISIBLE);
                        btn.setText("Sim");
                        edit_btn.setText("Não");
                    }

                }
            });

        }catch (Exception e)

        {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public void btn_add(View v) {
        try {
            Capitulo novo_cap = new Capitulo();

            novo_cap.setNome(editText_nomecap.getText().toString());

            SQL_Capitulo.Inserir(novo_cap);
            Toast.makeText(this,"Inserido",Toast.LENGTH_LONG).show();
            listview_cap.setAdapter(SQL_Capitulo.Listar_Capitulos(this,android.R.layout.simple_list_item_1));
        }catch (Exception e){
            Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }
}
