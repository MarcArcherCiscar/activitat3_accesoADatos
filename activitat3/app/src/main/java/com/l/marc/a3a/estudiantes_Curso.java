package com.l.marc.a3a;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class estudiantes_Curso extends AppCompatActivity {

    EditText curso;
    TextView cursos;
    Button buscar;
    MyDBAdapter dbAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estudiantes__curso);

        curso = (EditText) findViewById(R.id.curso);
        cursos = (TextView) findViewById(R.id.cursos);
        buscar = (Button) findViewById(R.id.buscar);
        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buscar(curso.getText().toString());
            }

        });
    }
        private void buscar(String curso){
            dbAdapter = new MyDBAdapter(this);
            dbAdapter.open();
            ArrayList<String> alumnos = dbAdapter.recuperarAlumnosPorCurso(curso);
            this.cursos.setText("");
            for(int cont=0;cont<alumnos.size();cont++){
                cursos.setText(cursos.getText()+" "+alumnos.get(cont)+"\n");

            }
        }
}
