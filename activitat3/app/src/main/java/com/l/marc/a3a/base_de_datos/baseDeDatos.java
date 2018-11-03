package com.l.marc.a3a.base_de_datos;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import static com.l.marc.a3a.utilitat.utilitat_alumnes.crear_tabla_alumno;
import static com.l.marc.a3a.utilitat.utilitat_profesors.crear_tabla_profesor;


public class baseDeDatos extends SQLiteOpenHelper{




    public baseDeDatos(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(crear_tabla_alumno);
        db.execSQL(crear_tabla_profesor);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS ALUMNOS");
        db.execSQL("DROP TABLE IF EXISTS PROFESORES");
        onCreate(db);

    }

}
