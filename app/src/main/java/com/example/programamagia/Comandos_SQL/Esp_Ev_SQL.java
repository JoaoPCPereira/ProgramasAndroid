package com.example.programamagia.Comandos_SQL;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ArrayAdapter;

import com.example.programamagia.Comandos_SQL.Entidades.Esp_Ev;

public class Esp_Ev_SQL {
    private SQLiteDatabase connection;

    public Esp_Ev_SQL(SQLiteDatabase conn){

        this.connection=conn;
    }

    public void Inserir (Esp_Ev novo ){

        ContentValues dados = new ContentValues();
        dados.put("Id_Evento", novo.getId_Evento());
        dados.put("Id_Espectaculo", novo.getId_Espectaculo());
        dados.put("Obs", novo.getObs());
        connection.insertOrThrow("TBL_Esp_Ev",null,dados);
    }

    public void Editar (Esp_Ev Ev){

        ContentValues dados = new ContentValues();
        dados.put("Id_Evento", Ev.getId_Evento());
        dados.put("Id_Espectaculo", Ev.getId_Espectaculo());
        dados.put("Obs", Ev.getObs());
        connection.update("TBL_Esp_Ev", dados ,"Id_Esp_Ev = " + Ev.getId_Esp_Ev(), null);
    }

    public void Apagar (Integer Id_ev ){

        connection.delete("TBL_Esp_Ev","Id_Esp_Ev = " + Id_ev, null);
    }

    public ArrayAdapter<Esp_Ev> Listar_Esp_Ev (Context context){

        ArrayAdapter<Esp_Ev> list_ev = new ArrayAdapter<Esp_Ev>(context,android.R.layout.simple_list_item_1);

        Cursor cursor= connection.query("TBL_Esp_Ev",null,null,null,null,null,null,null);
        cursor.moveToFirst();
        if (cursor.getCount()>0){
            do {

                Esp_Ev Esp_Ev= new Esp_Ev();
                Esp_Ev.setId_Esp_Ev(Integer.parseInt(cursor.getString(0)));
                Esp_Ev.setId_Evento(Integer.parseInt(cursor.getString(1)));
                Esp_Ev.setId_Espectaculo(Integer.parseInt(cursor.getString(2)));
                Esp_Ev.setObs(cursor.getString(3));
                list_ev.add(Esp_Ev);
            }
            while (cursor.moveToNext());
        }
        return list_ev;
    }
}
