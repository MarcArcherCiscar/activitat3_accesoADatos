package com.l.marc.a3a;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class consultar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar);
    }

    public void consultar(View view) {

        Intent i = new Intent(this, registrar_alumno.class);
        startActivity(i);
    }


    public void todos_alumnos(View view) {
        Intent c_a =new Intent(this, todos_alumnos.class);
        startActivity(c_a);
    }

    public void buscar_Ciclo(View view) {
        Intent b_c =new Intent(this,estudiantes_porCiclo.class);
        startActivity(b_c);
    }

    public void buscar_Curso(View view) {
        Intent b_curso=new Intent(this,estudiantes_Curso.class);
        startActivity(b_curso);
    }

    public void todos_profesores(View view) {
        Intent profesores=new Intent(this,todos_profesores.class);
        startActivity(profesores);
    }

    public void buscar_todos(View view) {
        Intent todos=new Intent(this, buscar_todos.class);
        startActivity(todos);
    }
}






