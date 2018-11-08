package com.l.marc.a3a;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import static com.l.marc.a3a.utilitat.utilitat_alumnes.TABLA_ALUMNO;
import static com.l.marc.a3a.utilitat.utilitat_alumnes.crear_tabla_alumno;
import static com.l.marc.a3a.utilitat.utilitat_profesors.TABLA_PROFESOR;
import static com.l.marc.a3a.utilitat.utilitat_profesors.crear_tabla_profesor;

public class MyDBAdapter {
    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME = "bd";



    // Contexto de la aplicación que usa la base de datos
    private final Context context;
    // Clase SQLiteOpenHelper para crear/actualizar la base de datos
    private baseDeDatos dbHelper;
    // Instancia de la base de datos
    private SQLiteDatabase db;

    public MyDBAdapter (Context c){
        context = c;
        dbHelper = new baseDeDatos(context, DATABASE_NAME, null, DATABASE_VERSION);
        //OJO open();
    }

    public void open(){

        try{
            db = dbHelper.getWritableDatabase();
        }catch(SQLiteException e){
            db = dbHelper.getReadableDatabase();
        }

    }
    public ArrayList<String> recuperarAlumnos(){
        ArrayList<String> alumnos = new ArrayList<String>();
        //Recuperamos en un cursor la consulta realizada
        Cursor cursor = db.query(TABLA_ALUMNO,null,null,null,null,null,null);
        //Recorremos el cursor
        if (cursor != null && cursor.moveToFirst()){
            do{
                alumnos.add(cursor.getString(0)+" "+cursor.getString(1)+" "+cursor.getString(2)+" "+cursor.getString(3)+" ");
            }while (cursor.moveToNext());
        }
        return alumnos;
    }

    public ArrayList<String> recuperarAlumnosPorCiclo(String ciclo){
        ArrayList<String> alumnos = new ArrayList<String>();
        //Recuperamos en un cursor la consulta realizada
        Cursor cursor = db.query(TABLA_ALUMNO,null, "ciclo='"+ciclo+"'", null,null,null,null,null);
        //Recorremos el cursor
        if (cursor != null && cursor.moveToFirst()){
            do{

                alumnos.add(cursor.getString(0)+" "+cursor.getString(1)+" "+cursor.getString(2)+" "+cursor.getString(3)+" ");
            }while (cursor.moveToNext());
        }
        return alumnos;
    }

    public ArrayList<String> recuperarAlumnosPorCurso(String curso){
        ArrayList<String> alumnos = new ArrayList<String>();
        //Recuperamos en un cursor la consulta realizada
        Cursor cursor = db.query(TABLA_ALUMNO,null,"curso='"+curso+"'",null,null,null,null);
        //Recorremos el cursor
        if (cursor != null && cursor.moveToFirst()){
            do{

                alumnos.add(cursor.getString(0)+" "+cursor.getString(1)+" "+cursor.getString(2)+" "+cursor.getString(3)+" ");
            }while (cursor.moveToNext());
        }
        return alumnos;
    }

    public ArrayList<String> recuperarProfesores(){
        ArrayList<String> profesores = new ArrayList<String>();
        //Recuperamos en un cursor la consulta realizada
        Cursor cursor = db.query(TABLA_PROFESOR,null,null,null,null,null,null);
        //Recorremos el cursor
        if (cursor != null && cursor.moveToFirst()){
            do{
                profesores.add(cursor.getString(0)+" "+cursor.getString(1)+" "+cursor.getString(2)+" "+cursor.getString(3)+" "+cursor.getString(4)+" ");
            }while (cursor.moveToNext());
        }
        return profesores;
    }

    public static class baseDeDatos extends SQLiteOpenHelper {




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
}
