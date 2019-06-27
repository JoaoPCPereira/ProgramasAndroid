package com.example.programamagia;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ListView;

import com.example.programamagia.BD.BaseDados;
import com.example.programamagia.Comandos_SQL.Clientes_SQL;

public class Gestao_Truques_App extends AppCompatActivity {
    private BaseDados BD;
    private Button btn_idiomas, btn_geral, btn_misc;
    private SQLiteDatabase connection;

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestao_clientes);
        BD = new BaseDados(this);
        connection = BD.getWritableDatabase();

    }
}