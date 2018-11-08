package com.l.marc.a3a;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class buscar_todos extends AppCompatActivity {

     TextView alumnos_todos;
     TextView profesores_todos;
     MyDBAdapter dbAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_todos);

        alumnos_todos=(TextView)findViewById(R.id.alumnos_todos);
        profesores_todos=(TextView) findViewById(R.id.profesores);

        dbAdapter = new MyDBAdapter(this);
        dbAdapter.open();

        ArrayList<String> alumnos = dbAdapter.recuperarAlumnos();
        alumnos_todos.setText("");

        for(int cont=0;cont<alumnos.size();cont++){
            alumnos_todos.setText(alumnos_todos.getText()+" "+alumnos.get(cont)+"\n");
        }

        ArrayList<String> profesores = dbAdapter.recuperarProfesores();
        profesores_todos.setText("");
        //textView2.setText(discos.get(1));
        for(int cont=0;cont<profesores.size();cont++){
            profesores_todos.setText(profesores_todos.getText()+" "+profesores.get(cont)+"\n");
        }

    }
}
