package com.example.programamagia.Comandos_SQL;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ArrayAdapter;

import com.example.programamagia.Comandos_SQL.Entidades.Sub_Capitulo;

import java.util.ArrayList;

public class Sub_Capitulos_SQL {
    private SQLiteDatabase connection;

    public Sub_Capitulos_SQL(SQLiteDatabase conn){

        this.connection=conn;
    }

    public void Inserir_Sub_Capitulo (Sub_Capitulo novo_sub ){

        ContentValues dados = new ContentValues();
        dados.put("Nome", novo_sub.getNome());
        dados.put("Id_Cap", novo_sub.getId_Cap());
        dados.put("Obs", novo_sub.getObs());
        connection.insertOrThrow("TBL_Sub_Capitulo",null,dados);
    }

    public void Editar_Sub_Capitulo (Sub_Capitulo Sub){

        ContentValues dados = new ContentValues();
        dados.put("Nome", Sub.getNome());
        dados.put("Id_Cap", Sub.getId_Cap());
        dados.put("Obs", Sub.getObs());
        connection.update("TBL_Sub_Capitulo", dados ,"Id_cap = " + Sub.getId_Cap(), null);
    }

    public void Apagar_Sub_Capitulo (Integer Id_cap ){

        connection.delete("TBL_Sub_Capitulo","Id_cap = " + Id_cap, null);
    }

    public ArrayAdapter<Sub_Capitulo> Listar_Sub_Capitulos (Context context,int id_cap, int res){

        ArrayAdapter<Sub_Capitulo> list_sub_cap = new ArrayAdapter<Sub_Capitulo>(context,res);
        String sel = "Id_Cap="+id_cap;
        //se for 0 lista todos (null) os sub_capitulos se nao so lista os que tem o id igual ao id_cap
        if (id_cap== 0)
            sel = null;

        Cursor cursor= connection.query("TBL_Sub_Capitulo",null,sel,null,null,null,null,null);
        cursor.moveToFirst();
        if (cursor.getCount()>0){
            do {

                Sub_Capitulo SubCapitulo= new Sub_Capitulo();
                SubCapitulo.setId_Sub_Cap(Integer.parseInt(cursor.getString(0)));
                SubCapitulo.setId_Cap(Integer.parseInt(cursor.getString(1)));
                SubCapitulo.setNome(cursor.getString(2));
                SubCapitulo.setObs(cursor.getString(3));
                list_sub_cap.add(SubCapitulo);
            }
            while (cursor.moveToNext());
        }
        return list_sub_cap;
    }
    public ArrayList<Sub_Capitulo> Listar_Sub_Capitulos_edittxt (int id_cap) {

        ArrayList<Sub_Capitulo> list_sub_cap = new ArrayList<Sub_Capitulo>();
        String sel = "Id_Cap=" + id_cap;
        //se for 0 lista todos (null) os sub_capitulos se nao so lista os que tem o id igual ao id_cap
        if (id_cap == 0)
            sel = null;

        Cursor cursor = connection.query("TBL_Sub_Capitulo", null, sel, null, null, null, null, null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            do {

                Sub_Capitulo SubCapitulo = new Sub_Capitulo();
                SubCapitulo.setId_Sub_Cap(Integer.parseInt(cursor.getString(0)));
                SubCapitulo.setId_Cap(Integer.parseInt(cursor.getString(1)));
                SubCapitulo.setNome(cursor.getString(2));
                SubCapitulo.setObs(cursor.getString(3));
                list_sub_cap.add(SubCapitulo);
            }
            while (cursor.moveToNext());
        }
        return list_sub_cap;
    }

    public Sub_Capitulo Sub_Capitulo_by_Id (int id_sub){

        Cursor cursor= connection.query("TBL_Sub_Capitulo",null,"Id_Sub_Cap = " + id_sub,null,null,null,null,null);
        cursor.moveToFirst();

        Sub_Capitulo sub_capitulo= new Sub_Capitulo();
        sub_capitulo.setId_Sub_Cap(Integer.parseInt(cursor.getString(0)));
        sub_capitulo.setId_Cap(Integer.parseInt(cursor.getString(1)));
        sub_capitulo.setNome(cursor.getString(2));
        sub_capitulo.setObs(cursor.getString(3));


        return sub_capitulo;
    }
}
