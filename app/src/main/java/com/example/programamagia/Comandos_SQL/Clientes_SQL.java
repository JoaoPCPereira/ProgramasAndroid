package com.example.programamagia.Comandos_SQL;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ArrayAdapter;

import com.example.programamagia.Comandos_SQL.Entidades.Cliente;

public class Clientes_SQL {

        private SQLiteDatabase connection;

        public Clientes_SQL(SQLiteDatabase conn){

            this.connection=conn;
        }

        public void Inserir (Cliente novo ){

            ContentValues dados = new ContentValues();
            dados.put("Nome", novo.getNome());
            dados.put("Numero", novo.getNumero());
            dados.put("E-Mail", novo.getEmail());
            dados.put("Obs", novo.getObs());
            connection.insertOrThrow("TBL_Clientes",null,dados);
        }

        public void Editar (Cliente Cli){

            ContentValues dados = new ContentValues();
            dados.put("Nome", Cli.getNome());
            dados.put("Numero", Cli.getNumero());
            dados.put("E-Mail", Cli.getEmail());
            dados.put("Obs", Cli.getObs());
            connection.update("TBL_Clientes", dados ,"Id_Cliente = " + Cli.getId_Cliente(), null);
        }

        public void Apagar (Integer Id_cli ){

            connection.delete("TBL_Clientes","Id_Cliente = " + Id_cli, null);
        }

        public ArrayAdapter<Cliente> Listar_Clientes (Context context){

            ArrayAdapter<Cliente> list_cli = new ArrayAdapter<Cliente>(context,android.R.layout.simple_list_item_1);

            Cursor cursor= connection.query("TBL_Clientes",null,null,null,null,null,null,null);
            cursor.moveToFirst();
            if (cursor.getCount()>0){
                do {

                    Cliente Cliente= new Cliente();
                    Cliente.setId_Cliente(Integer.parseInt(cursor.getString(0)));
                    Cliente.setNome(cursor.getString(1));
                    Cliente.setNumero(Integer.parseInt(cursor.getString(2)));
                    Cliente.setEmail(cursor.getString(3));
                    Cliente.setObs(cursor.getString(4));
                    list_cli.add(Cliente);
                }
                while (cursor.moveToNext());
            }
            return list_cli;
        }
    }
