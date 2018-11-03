package com.l.marc.a3a;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.l.marc.a3a.base_de_datos.baseDeDatos;

import static com.l.marc.a3a.utilitat.utilitat_alumnes.CAMPO_CICLO;
import static com.l.marc.a3a.utilitat.utilitat_alumnes.CAMPO_CURSO;
import static com.l.marc.a3a.utilitat.utilitat_alumnes.CAMPO_EDAD;
import static com.l.marc.a3a.utilitat.utilitat_alumnes.CAMPO_NOMBRE;
import static com.l.marc.a3a.utilitat.utilitat_alumnes.TABLA_ALUMNO;

public class registrar_alumno extends AppCompatActivity {
    EditText nombre;
    EditText edad;
    EditText ciclo;
    EditText curso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_alumno);

        nombre=(EditText)findViewById(R.id.nombre_alumno);
        edad=(EditText)findViewById(R.id.edad_alumno);
        ciclo=(EditText)findViewById(R.id.ciclo);
        curso=(EditText)findViewById(R.id.curso);
    }

    public void onClick(View view) {
        registrarAlumnos();
    }

    private void registrarAlumnos() {
        baseDeDatos conexion= new baseDeDatos(this, "bd",null,1);
        SQLiteDatabase db=conexion.getWritableDatabase();

        ContentValues values= new ContentValues();
        values.put(CAMPO_NOMBRE, nombre.getText().toString());
        values.put(CAMPO_EDAD, edad.getText().toString());
        values.put(CAMPO_CICLO,ciclo.getText().toString());
        values.put(CAMPO_CURSO, curso.getText().toString());

        Long resultado=db.insert(TABLA_ALUMNO, CAMPO_NOMBRE, values );
        Toast.makeText(getApplicationContext(),"Registro:"+resultado,Toast.LENGTH_SHORT).show();
        db.close();

    }
}
