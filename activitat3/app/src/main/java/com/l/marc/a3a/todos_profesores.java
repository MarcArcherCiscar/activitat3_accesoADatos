package com.l.marc.a3a;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class todos_profesores extends AppCompatActivity {
    TextView profs;
    private MyDBAdapter dbAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todos_profesores);
        profs=(TextView)findViewById(R.id.profs);

        dbAdapter = new MyDBAdapter(this);
        dbAdapter.open();

        ArrayList<String> alumnos = dbAdapter.recuperarProfesores();
        profs.setText("");
        for(int cont=0;cont<alumnos.size();cont++){
            profs.setText(profs.getText()+" "+alumnos.get(cont)+"\n");
        }
    }



}
