package com.l.marc.a3a;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.l.marc.a3a.base_de_datos.baseDeDatos;

import static com.l.marc.a3a.utilitat.utilitat_profesors.CAMPO_CICLO;
import static com.l.marc.a3a.utilitat.utilitat_profesors.CAMPO_CURSO;
import static com.l.marc.a3a.utilitat.utilitat_profesors.CAMPO_DESPACHO;
import static com.l.marc.a3a.utilitat.utilitat_profesors.CAMPO_EDAD;
import static com.l.marc.a3a.utilitat.utilitat_profesors.CAMPO_NOMBRE;
import static com.l.marc.a3a.utilitat.utilitat_profesors.TABLA_PROFESOR;

public class registrar_profesor extends AppCompatActivity {
EditText nombre;
EditText edad;
EditText ciclo;
EditText curso;
EditText despacho;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_profesor);
        nombre=(EditText)findViewById(R.id.nombre_profesor);
        edad=(EditText)findViewById(R.id.edad_profesor);
        ciclo=(EditText)findViewById(R.id.ciclo_profesor);
        curso=(EditText)findViewById(R.id.curso_profesor);
        despacho=(EditText)findViewById(R.id.despacho);
    }

    public void onClick(View view) {
        registrarProfesores();
    }

    private void registrarProfesores() {
        baseDeDatos conexion= new baseDeDatos(this, "bd",null,1);
        SQLiteDatabase db=conexion.getWritableDatabase();

        ContentValues values= new ContentValues();
        values.put(CAMPO_NOMBRE, nombre.getText().toString());
        values.put(CAMPO_EDAD, edad.getText().toString());
        values.put(CAMPO_CICLO,ciclo.getText().toString());
        values.put(CAMPO_CURSO, curso.getText().toString());
        values.put(CAMPO_DESPACHO, despacho.getText().toString());

        Long resultado=db.insert(TABLA_PROFESOR, CAMPO_CICLO, values );
        Toast.makeText(getApplicationContext(),"Registro:"+resultado,Toast.LENGTH_SHORT).show();
        db.close();
    }
}
