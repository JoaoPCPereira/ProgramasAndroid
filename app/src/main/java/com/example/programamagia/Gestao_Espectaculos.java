package com.example.programamagia;

import android.content.DialogInterface;
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
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.programamagia.BD.BaseDados;
import com.example.programamagia.Comandos_SQL.Capitulos_SQL;
import com.example.programamagia.Comandos_SQL.Entidades.Capitulo;
import com.example.programamagia.Comandos_SQL.Entidades.Sub_Capitulo;
import com.example.programamagia.Comandos_SQL.Sub_Capitulos_SQL;



public class Gestao_Espectaculos extends AppCompatActivity {

    private TextView textView_nome, textView_obs;
    private EditText editText_nome, editText_obs;
    private Spinner spinner_cap;
    private Button button_add;
    private ListView listview_Sub;
    private BaseDados BD;
    private SQLiteDatabase connection;
    private Sub_Capitulos_SQL SQL_Sub_Capitulo;
    private Capitulos_SQL SQL_Capitulo;
    private ArrayAdapter<Sub_Capitulo> List_Sub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestao_espectaculos);
        try {
            BD = new BaseDados(this);
            connection = BD.getWritableDatabase();
            SQL_Sub_Capitulo = new Sub_Capitulos_SQL(connection);
            SQL_Capitulo = new Capitulos_SQL(connection);

            textView_nome = (TextView) findViewById(R.id.textView_nome_sub_cap);
            editText_nome = (EditText) findViewById(R.id.editText_nome_sub_cap);
            textView_obs = (TextView) findViewById(R.id.textView_obs_sub_cap);
            editText_obs = (EditText) findViewById(R.id.editText_obs_sub_cap);
            spinner_cap = (Spinner) findViewById(R.id.spinner_cap);
            button_add = (Button) findViewById(R.id.button_add_sub_cap);
            listview_Sub = (ListView) findViewById(R.id.listview_sub_capitulos);

            listview_Sub.setAdapter(SQL_Sub_Capitulo.Listar_Sub_Capitulos(this,0, android.R.layout.simple_list_item_1));
            spinner_cap.setAdapter(SQL_Capitulo.Listar_Capitulos(this,android.R.layout.simple_list_item_1  ));

            listview_Sub.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                    int id_Sub_Cap = ((Sub_Capitulo) listview_Sub.getItemAtPosition(position)).getId_Sub_Cap() ;
                    longclick_event(position, id_Sub_Cap);
                    return true;
                }
            });
            spinner_cap.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    int id_cap = ((Capitulo) spinner_cap.getItemAtPosition(position)).getId_Cap();
                    listview_Sub.setAdapter(SQL_Sub_Capitulo.Listar_Sub_Capitulos(Gestao_Espectaculos.this,id_cap, android.R.layout.simple_list_item_1));

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });


        }catch (Exception e)

        {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
    public void longclick_event(final int pos, final int id_sub_cap) {
        try{
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

                            SQL_Sub_Capitulo.Apagar_Sub_Capitulo(id_sub_cap);
                            Toast.makeText(Gestao_Espectaculos.this,"Eliminado",Toast.LENGTH_LONG).show();
                            listview_Sub.setAdapter(SQL_Sub_Capitulo.Listar_Sub_Capitulos(Gestao_Espectaculos.this, 0, android.R.layout.simple_list_item_1));
                        }
                    });
            builder.show();
        }catch (Exception e)

        {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public void btn_add(View v) {
        try {
            Sub_Capitulo novo_Sub = new Sub_Capitulo();

            novo_Sub.setNome(editText_nome.getText().toString());
            novo_Sub.setId_Cap(((Capitulo) spinner_cap.getSelectedItem()).getId_Cap());
            novo_Sub.setObs(editText_obs.getText().toString());
            SQL_Sub_Capitulo.Inserir_Sub_Capitulo(novo_Sub);
            Toast.makeText(this,"Inserido",Toast.LENGTH_LONG).show();
            listview_Sub.setAdapter(SQL_Sub_Capitulo.Listar_Sub_Capitulos(this, 0, android.R.layout.simple_list_item_1));
        }catch (Exception e){
            Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }
}
