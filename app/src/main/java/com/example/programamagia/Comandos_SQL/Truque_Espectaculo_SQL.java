package com.example.programamagia.Comandos_SQL;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ArrayAdapter;

import com.example.programamagia.Comandos_SQL.Entidades.Truque_Espectaculo;

    public class Truque_Espectaculo_SQL {
        private SQLiteDatabase connection;

        public Truque_Espectaculo_SQL(SQLiteDatabase conn){

            this.connection=conn;
        }

        public void Inserir (Truque_Espectaculo novo ){

            ContentValues dados = new ContentValues();
            dados.put("Id_Truque", novo.getId_Truque());
            dados.put("Id_Espectaculo", novo.getId_Espectaculo());
            dados.put("Obs", novo.getObs());
            connection.insertOrThrow("TBL_Truque_Espectaculos",null,dados);
        }

        public void Editar (Truque_Espectaculo Ev){

            ContentValues dados = new ContentValues();
            dados.put("Id_Truque", Ev.getId_Truque());
            dados.put("Id_Espectaculo", Ev.getId_Espectaculo());
            dados.put("Obs", Ev.getObs());
            connection.update("TBL_Truque_Espectaculos", dados ,"Id_Truque_Espectaculos = " + Ev.getId_Truque_Espectaculos(), null);
        }

        public void Apagar (Integer Id_ev ){

            connection.delete("TBL_Truque_Espectaculos","Id_Truque_Espectaculos = " + Id_ev, null);
        }

        public ArrayAdapter<Truque_Espectaculo> Listar_Truque_Espectaculo (Context context){

            ArrayAdapter<Truque_Espectaculo> list_ev = new ArrayAdapter<Truque_Espectaculo>(context,android.R.layout.simple_list_item_1);

            Cursor cursor= connection.query("TBL_Truque_Espectaculos",null,null,null,null,null,null,null);
            cursor.moveToFirst();
            if (cursor.getCount()>0){
                do {

                    Truque_Espectaculo Truque_Espectaculo= new Truque_Espectaculo();
                    Truque_Espectaculo.setId_Truque_Espectaculos(Integer.parseInt(cursor.getString(0)));
                    Truque_Espectaculo.setId_Truque(Integer.parseInt(cursor.getString(1)));
                    Truque_Espectaculo.setId_Espectaculo(Integer.parseInt(cursor.getString(2)));
                    Truque_Espectaculo.setObs(cursor.getString(3));
                    list_ev.add(Truque_Espectaculo);
                }
                while (cursor.moveToNext());
            }
            return list_ev;
        }
    }

