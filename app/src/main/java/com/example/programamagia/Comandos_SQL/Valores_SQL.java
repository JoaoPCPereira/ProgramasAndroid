package com.example.programamagia.Comandos_SQL;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ArrayAdapter;

import com.example.programamagia.Comandos_SQL.Entidades.Sub_Capitulo;
import com.example.programamagia.Comandos_SQL.Entidades.Truque;
import com.example.programamagia.Comandos_SQL.Entidades.Valor;

import java.util.ArrayList;

public class Valores_SQL {
    private SQLiteDatabase connection;

    public Valores_SQL(SQLiteDatabase conn){

        this.connection=conn;
    }

    public void Inserir (Valor novo ){

        ContentValues dados = new ContentValues();
        dados.put("Id_Truque", novo.getTruque().getId_Truque());
        dados.put("Id_Sub_Cap", novo.getSub_Cap().getId_Sub_Cap());
        dados.put("Valor", novo.getValor());
        dados.put("Obs", novo.getObs());
        connection.insertOrThrow("TBL_Valores",null,dados);
    }

    public void Editar (Valor Val){

        ContentValues dados = new ContentValues();
        //dados.put("Id_Truque", Val.getId_Truque());
        //dados.put("Id_Sub_Cap", Val.getId_Sub_Cap());
        dados.put("Valor", Val.getValor());
        //dados.put("Obs", Val.getObs());
        connection.update("TBL_Valores", dados ,"Id_Valores = " + Val.getId_Valores(), null);
    }
    public void Apagar (Integer Id_val ){

        connection.delete("TBL_Valores","Id_Valores = " + Id_val, null);
    }

    public ArrayAdapter<Valor> Listar_Valores (Context context){

        ArrayAdapter<Valor> list_val = new ArrayAdapter<Valor>(context,android.R.layout.simple_list_item_1);

        Cursor cursor= connection.query("TBL_Valores",null,null,null,null,null,null,null);
        cursor.moveToFirst();
        if (cursor.getCount()>0){
            do {

                Valor Valor= new Valor();
                Valor.setId_Valores(Integer.parseInt(cursor.getString(0)));
                Valor.setTruque((new Truques_SQL(connection)).Truque_by_Id(Integer.parseInt(cursor.getString(1))) );
                Valor.setSub_Cap((new Sub_Capitulos_SQL(connection)).Sub_Capitulo_by_Id(Integer.parseInt(cursor.getString(2))) );
                Valor.setValor(cursor.getString(3));
                Valor.setObs(cursor.getString(4));
                list_val.add(Valor);
            }
            while (cursor.moveToNext());
        }
        return list_val;
    }
    public ArrayList<Valor> Listar_EditText (ArrayList<Integer> pos_v){

        ArrayList<Valor> list_val = new ArrayList<>();

        String selectionIdsClause = "";

        for (int i=0;i<pos_v.size();i++){
            selectionIdsClause += "Id_Sub_Cap = " + pos_v.get(i);
            if(i!=pos_v.size()-1){
                selectionIdsClause += " or ";
            }

        }

        Cursor cursor= connection.query("TBL_Valor",null,selectionIdsClause,null,null,null,null,null);
        cursor.moveToFirst();
        if (cursor.getCount()>0){
            do {

                Valor Valor= new Valor();
                Valor.setId_Valores(Integer.parseInt(cursor.getString(0)));
                Valor.setTruque((new Truques_SQL(connection)).Truque_by_Id(Integer.parseInt(cursor.getString(1))) );
                Valor.setSub_Cap((new Sub_Capitulos_SQL(connection)).Sub_Capitulo_by_Id(Integer.parseInt(cursor.getString(2))) );
                Valor.setValor(cursor.getString(3));
                Valor.setObs(cursor.getString(4));
                list_val.add(Valor);
            }
            while (cursor.moveToNext());
        }
        return list_val;
    }
}