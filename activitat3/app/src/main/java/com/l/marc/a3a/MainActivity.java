package com.l.marc.a3a;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText nombre_real;
    private EditText nombre_usuario;
    private EditText fecha;
    private Button mostrar;
    private  Button guardar;
    private RadioGroup sexo;
    private RadioButton hombre;
    private  RadioButton mujer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Context context = this;
        final SharedPreferences sharprefs = getSharedPreferences("Almacen", context.MODE_PRIVATE);

        nombre_real=(EditText) findViewById(R.id.nombre_real);
        nombre_usuario=(EditText) findViewById(R.id.nombre_usuario);
        fecha=(EditText)findViewById(R.id.fecha_nacimiento);
        mostrar = (Button)findViewById(R.id.mostrar);
        guardar =(Button)findViewById(R.id.guardar);
        sexo=(RadioGroup)findViewById(R.id.sexo);

        mostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharpref = getPreferences(context.MODE_PRIVATE);

                String nombreR = sharpref.getString("nombreReal","No hay dato");
                String nombreU = sharpref.getString("nombreUsuario","No hay dato");
                String fecha = sharpref.getString("fecha","No hay dato");
                String sexo= sharpref.getString("sexo","No hay dato");

                Toast.makeText(getApplicationContext(), "Dato guardado : Nombre real: "+nombreR+", Nombre de usuario: "+nombreU+",Fecha de nacimiento: "+fecha+", Sexo: "+sexo,Toast.LENGTH_LONG).show();

            }
        });

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int sexoId=sexo.getCheckedRadioButtonId();
                hombre=(RadioButton) findViewById(sexoId);


                SharedPreferences sharpref = getPreferences(context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharpref.edit();
                editor.putString("nombreReal", nombre_real.getText().toString());
                editor.putString("nombreUsuario", nombre_usuario.getText().toString());
                editor.putString("fecha", fecha.getText().toString());
                editor.putString("sexo",hombre.getText().toString());
                
                editor.commit();

            }
        });
    }

    public void registrar(View view) {
        main_registrar al=new main_registrar();
        Intent i = new Intent(this, main_registrar.class);
        startActivity(i);
    }


    public void consultar(View view) {
        main_registrar al=new main_registrar();
        Intent i = new Intent(this, consultar.class);
        startActivity(i);
    }
}
