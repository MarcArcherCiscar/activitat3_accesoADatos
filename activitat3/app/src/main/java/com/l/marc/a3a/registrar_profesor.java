package com.l.marc.a3a;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


import static com.l.marc.a3a.utilitat.utilitat_profesors.CAMPO_CICLO_PROFESOR;

import static com.l.marc.a3a.utilitat.utilitat_profesors.CAMPO_CURSO_PROFESOR;

import static com.l.marc.a3a.utilitat.utilitat_profesors.CAMPO_DESPACHO_PROFESOR;

import static com.l.marc.a3a.utilitat.utilitat_profesors.CAMPO_EDAD_PROFESOR;

import static com.l.marc.a3a.utilitat.utilitat_profesors.CAMPO_NOMBRE_PROFESOR;
import static com.l.marc.a3a.utilitat.utilitat_profesors.TABLA_PROFESOR;

public class registrar_profesor extends AppCompatActivity {
    EditText nombre_profesor_registrar;
    EditText edad_profesor_registrar;
    EditText ciclo_profesor_registrar;
    EditText curso_profesor_registrar;
    EditText despacho_profesor_registrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_profesor);

        nombre_profesor_registrar=(EditText)findViewById(R.id.nombre_profesor);
        edad_profesor_registrar=(EditText)findViewById(R.id.edad_profesor);
        ciclo_profesor_registrar=(EditText)findViewById(R.id.ciclo_profesor);
        curso_profesor_registrar=(EditText)findViewById(R.id.curso_profesor);
        despacho_profesor_registrar=(EditText)findViewById(R.id.despacho);
    }

    public void onClick(View view) {
        registrarProfesores();
    }

    private void registrarProfesores() {
        MyDBAdapter.baseDeDatos conexion= new MyDBAdapter.baseDeDatos(this, "bd",null,1);
        SQLiteDatabase db=conexion.getWritableDatabase();

        ContentValues values= new ContentValues();
        values.put(CAMPO_NOMBRE_PROFESOR, nombre_profesor_registrar.getText().toString());
        values.put(CAMPO_EDAD_PROFESOR, edad_profesor_registrar.getText().toString());
        values.put(CAMPO_CICLO_PROFESOR,ciclo_profesor_registrar.getText().toString());
        values.put(CAMPO_CURSO_PROFESOR, curso_profesor_registrar.getText().toString());
        values.put(CAMPO_DESPACHO_PROFESOR, despacho_profesor_registrar.getText().toString());

        Long resultado=db.insert(TABLA_PROFESOR, CAMPO_NOMBRE_PROFESOR, values );
        Toast.makeText(getApplicationContext(),"Registro:"+resultado,Toast.LENGTH_SHORT).show();
        db.close();
    }
}
