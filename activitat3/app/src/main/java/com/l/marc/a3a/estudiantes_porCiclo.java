package com.l.marc.a3a;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class estudiantes_porCiclo extends AppCompatActivity {
    EditText ciclo;
    TextView ciclos;
    Button buscar;
    MyDBAdapter dbAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estudiantes_por_ciclo);
        ciclo = (EditText) findViewById(R.id.ciclo);
        ciclos=(TextView) findViewById(R.id.ciclos);
        buscar=(Button)findViewById(R.id.buscar);


        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buscar(ciclo.getText().toString());
            }
        });

    }

    private void buscar(String ciclo){
        dbAdapter = new MyDBAdapter(this);
        dbAdapter.open();
        ArrayList<String> alumnos = dbAdapter.recuperarAlumnosPorCiclo(ciclo);
        this.ciclos.setText("");
        for(int cont=0;cont<alumnos.size();cont++){

            ciclos.setText(ciclos.getText()+" "+alumnos.get(cont)+"\n");

        }
    }
}
