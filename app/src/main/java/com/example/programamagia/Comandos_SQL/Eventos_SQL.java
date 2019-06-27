package com.example.programamagia.Comandos_SQL;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ArrayAdapter;

import com.example.programamagia.Comandos_SQL.Entidades.Evento;

public class Eventos_SQL {
    private SQLiteDatabase connection;

    public Eventos_SQL(SQLiteDatabase conn){

        this.connection=conn;
    }

    public void Inserir (Evento novo ){

        ContentValues dados = new ContentValues();
        dados.put("Id_Cliente", novo.getId_Cliente());
        dados.put("Data", novo.getData());
        dados.put("Obs", novo.getObs());
        connection.insertOrThrow("TBL_Eventos",null,dados);
    }

    public void Editar (Evento Ev){

        ContentValues dados = new ContentValues();
        dados.put("Id_Cliente", Ev.getId_Cliente());
        dados.put("Data", Ev.getData());
        dados.put("Obs", Ev.getObs());
        connection.update("TBL_Eventos", dados ,"Id_Evento = " + Ev.getId_Evento(), null);
    }

    public void Apagar (Integer Id_ev ){

        connection.delete("TBL_Eventos","Id_Evento = " + Id_ev, null);
    }

    public ArrayAdapter<Evento> Listar_Eventos (Context context){

        ArrayAdapter<Evento> list_ev = new ArrayAdapter<Evento>(context,android.R.layout.simple_list_item_1);

        Cursor cursor= connection.query("TBL_Eventos",null,null,null,null,null,null,null);
        cursor.moveToFirst();
        if (cursor.getCount()>0){
            do {

                Evento Evento= new Evento();
                Evento.setId_Evento(Integer.parseInt(cursor.getString(0)));
                Evento.setId_Cliente(Integer.parseInt(cursor.getString(1)));
                Evento.setData(cursor.getString(2));
                Evento.setObs(cursor.getString(3));
                list_ev.add(Evento);
            }
            while (cursor.moveToNext());
        }
        return list_ev;
    }
}
