package com.l.marc.a3a;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class todos_alumnos extends AppCompatActivity {

    private TextView estudiantes;
    private MyDBAdapter dbAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todos_alumnos);

        dbAdapter = new MyDBAdapter(this);
        dbAdapter.open();

        TextView estudiantes = (TextView) this.findViewById(R.id.estudiantes);

        ArrayList<String> alumnos = dbAdapter.recuperarAlumnos();
        estudiantes.setText("");
        for(int cont=0;cont<alumnos.size();cont++){
            estudiantes.setText(estudiantes.getText()+" "+alumnos.get(cont)+"\n");

        }

    }

}
