package com.example.programamagia.Comandos_SQL;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ArrayAdapter;

import com.example.programamagia.Comandos_SQL.Entidades.Espectaculo;

public class Espectaculos_SQL {

    private SQLiteDatabase connection;

    public Espectaculos_SQL(SQLiteDatabase conn){

        this.connection=conn;
    }

    public void Inserir (Espectaculo novo ){

        ContentValues dados = new ContentValues();
        dados.put("Nome", novo.getNome());
        dados.put("Tipo", novo.getTipo());
        dados.put("Duração", novo.getDuracao());
        dados.put("Preço", novo.getPreco());
        dados.put("Obs", novo.getObs());
        connection.insertOrThrow("TBL_Espectaculos",null,dados);
    }

    public void Editar (Espectaculo Esp){

        ContentValues dados = new ContentValues();
        dados.put("Nome", Esp.getNome());
        dados.put("Tipo", Esp.getTipo());
        dados.put("Duração", Esp.getDuracao());
        dados.put("Preço", Esp.getPreco());
        dados.put("Obs", Esp.getObs());
        connection.update("TBL_Espectaculos", dados ,"Id_esp = " + Esp.getId_Espectaculo(), null);
    }

    public void Apagar (Integer Id_esp ){

        connection.delete("TBL_Espectaculos","Id_esp = " + Id_esp, null);
    }

    public ArrayAdapter<Espectaculo> Listar_Espectaculos (Context context){

        ArrayAdapter<Espectaculo> list_esp = new ArrayAdapter<Espectaculo>(context,android.R.layout.simple_list_item_1);

        Cursor cursor= connection.query("TBL_Espectaculos",null,null,null,null,null,null,null);
        cursor.moveToFirst();
        if (cursor.getCount()>0){
            do {

                Espectaculo Espectaculo= new Espectaculo();
                Espectaculo.setId_Espectaculo(Integer.parseInt(cursor.getString(0)));
                Espectaculo.setNome(cursor.getString(1));
                Espectaculo.setTipo(cursor.getString(2));
                Espectaculo.setDuracao(cursor.getString(3));
                Espectaculo.setPreco(Float.parseFloat (cursor.getString(4)));
                Espectaculo.setObs(cursor.getString(5));
                list_esp.add(Espectaculo);
            }
            while (cursor.moveToNext());
        }
        return list_esp;
    }
}
