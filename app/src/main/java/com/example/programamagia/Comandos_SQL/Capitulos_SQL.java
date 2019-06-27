package com.example.programamagia.Comandos_SQL;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ArrayAdapter;

import com.example.programamagia.Comandos_SQL.Entidades.Capitulo;

    public class Capitulos_SQL {

        private SQLiteDatabase connection;

        public Capitulos_SQL(SQLiteDatabase conn){

            this.connection=conn;
        }

        public void Inserir (Capitulo novo ){

            ContentValues dados = new ContentValues();
            dados.put("Nome", novo.getNome());
            dados.put("Obs", novo.getObs());
            connection.insertOrThrow("TBL_Capitulo",null,dados);
        }

        public void Editar (Capitulo Cap){

            ContentValues dados = new ContentValues();
            dados.put("Nome", Cap.getNome());
            dados.put("Obs", Cap.getObs());
            connection.update("TBL_Capitulo", dados ,"Id_cap = " + Cap.getId_Cap(), null);
        }

        public void Apagar (Integer Id_cap ){

            connection.delete("TBL_Capitulo","Id_cap = " + Id_cap, null);
        }

        public ArrayAdapter<Capitulo> Listar_Capitulos (Context context,int res){

            ArrayAdapter<Capitulo> list_cap = new ArrayAdapter<Capitulo>(context,res);

            Cursor cursor= connection.query("TBL_Capitulo",null,null,null,null,null,null,null);
            cursor.moveToFirst();
                    if (cursor.getCount()>0){
                        do {

                            Capitulo Capitulo= new Capitulo();
                            Capitulo.setId_Cap(Integer.parseInt(cursor.getString(0)));
                            Capitulo.setNome(cursor.getString(1));
                            Capitulo.setObs(cursor.getString(2));
                            list_cap.add(Capitulo);
                        }
                        while (cursor.moveToNext());
                    }
                    return list_cap;
        }
    }


