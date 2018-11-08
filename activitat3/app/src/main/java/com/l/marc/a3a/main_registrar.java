package com.l.marc.a3a;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class main_registrar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_registrar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        MyDBAdapter.baseDeDatos conexion= new MyDBAdapter.baseDeDatos(this, "bd",null,1);
    }

    public void registrar_alumno(View view) {
        main_registrar al=new main_registrar();
        Intent i = new Intent(this, registrar_alumno.class);
        startActivity(i);
    }

    public void registrar_profesor(View view) {
        main_registrar al=new main_registrar();
        Intent i = new Intent(this, registrar_profesor.class);
        startActivity(i);
    }
}
