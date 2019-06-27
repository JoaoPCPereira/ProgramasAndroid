package com.example.programamagia.Comandos_SQL;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ArrayAdapter;

import com.example.programamagia.Comandos_SQL.Entidades.Truque;

public class Truques_SQL {

    private SQLiteDatabase connection;

    public Truques_SQL(SQLiteDatabase conn){

        this.connection=conn;
    }

    public void Inserir (Truque novo ){

        ContentValues dados = new ContentValues();
        dados.put("Nome", novo.getNome());
        dados.put("Obs", novo.getObs());
        connection.insertOrThrow("TBL_Truques",null,dados);
    }

    public void Editar (Truque Truque){

        ContentValues dados = new ContentValues();
        dados.put("Nome", Truque.getNome());
        dados.put("Obs", Truque.getObs());
        connection.update("TBL_Truques", dados ,"Id_Truque = " + Truque.getId_Truque(), null);
    }

    public void Apagar (Integer Id_Truque ){

        connection.delete("TBL_Truques","Id_Truque = " + Id_Truque, null);
    }

    public ArrayAdapter<Truque> Listar_Truques (Context context){

        ArrayAdapter<Truque> list_Truque = new ArrayAdapter<Truque>(context,android.R.layout.simple_list_item_1);

        Cursor cursor= connection.query("TBL_Truques",null,null,null,null,null,null,null);
        cursor.moveToFirst();
        if (cursor.getCount()>0){
            do {

                Truque Truque= new Truque();
                Truque.setId_Truque(Integer.parseInt(cursor.getString(0)));
                Truque.setNome(cursor.getString(1));
                Truque.setObs(cursor.getString(2));
                list_Truque.add(Truque);
            }
            while (cursor.moveToNext());
        }
        return list_Truque;
    }

    public Truque Truque_by_Id (int id_truque){

        Cursor cursor= connection.query("TBL_Truques",null,"Id_Truque = " + id_truque,null,null,null,null,null);
        cursor.moveToFirst();

        Truque Truque= new Truque();
        Truque.setId_Truque(Integer.parseInt(cursor.getString(0)));
        Truque.setNome(cursor.getString(1));
        Truque.setObs(cursor.getString(2));


        return Truque;
    }
}
