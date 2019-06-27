package com.example.programamagia.BD;
import com.example.programamagia.BD.SQL;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BaseDados extends SQLiteOpenHelper {

    public BaseDados(Context context) {

            super(context, "BD_Magia_Teste6", null,1);

            // TODO Auto-generated constructor stub
        }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub

        db.execSQL(SQL.Create_TBL_Capitulo());
        db.execSQL(SQL.Create_TBL_Sub_Capitulo());
        db.execSQL(SQL.Create_TBL_Truques());
        db.execSQL(SQL.Create_TBL_Valores());
        db.execSQL(SQL.Create_TBL_Espectaculos());
        db.execSQL(SQL.Create_TBL_Eventos());
        db.execSQL(SQL.Create_TBL_Truque_Espectaculos());
        db.execSQL(SQL.Create_TBL_Esp_Ev());
        db.execSQL(SQL.Create_TBL_Cliente());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub

        onCreate(db);
    }
}
