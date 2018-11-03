package com.l.marc.a3a;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.l.marc.a3a.base_de_datos.alumno;
import com.l.marc.a3a.base_de_datos.baseDeDatos;
import com.l.marc.a3a.utilitat.utilitat_alumnes;

import java.util.ArrayList;
import java.util.List;

import static com.l.marc.a3a.utilitat.utilitat_alumnes.TABLA_ALUMNO;
import static com.l.marc.a3a.utilitat.utilitat_profesors.TABLA_PROFESOR;

public class consultar extends AppCompatActivity {

    ListView lista;
    ArrayList<String> listaInformacion;
    ArrayList<alumno> listaUsuarios;
    baseDeDatos conexion=new baseDeDatos(getApplicationContext(),"db",null,1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar);


        lista= (ListView) findViewById(R.id.lista);

        consultarListaPersonas();

        ArrayAdapter adaptador=new ArrayAdapter(this,android.R.layout.simple_list_item_1,listaInformacion);
        lista.setAdapter(adaptador);
}

    private void consultarListaPersonas() {
        SQLiteDatabase db=conexion.getReadableDatabase();

        alumno usuario=null;
        listaUsuarios=new ArrayList<alumno>();
        //select * from usuarios
        Cursor cursor=db.rawQuery("SELECT * FROM "+TABLA_ALUMNO,null);

        while (cursor.moveToNext()){
            usuario=new alumno();
            usuario.setNombre(cursor.getString(0));
            usuario.setEdad(cursor.getInt(1));
            usuario.setCiclo(cursor.getString(2));
            usuario.setCurso(cursor.getString(3));

            listaUsuarios.add(usuario);
        }
        obtenerLista();
    }

    private void obtenerLista() {
        listaInformacion=new ArrayList<String>();

        for (int i=0; i<listaUsuarios.size();i++){
            listaInformacion.add(listaUsuarios.get(i).getNombre()+" - "
                    +listaUsuarios.get(i).getEdad()+" - "
                    +listaUsuarios.get(i).getCiclo()+" - "
                    +listaUsuarios.get(i).getCurso());
        }

    }

}






