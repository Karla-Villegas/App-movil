package com.e.practicabd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class cursos extends AppCompatActivity {

    ListView lv_cursos;
    ArrayList<String> listaCursos;
    ArrayAdapter adaptador;

    Button btn_agregar, btn_editar, btn_eliminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cursos);


        final daoUsuario daoUsuario = new daoUsuario(getApplicationContext());

        btn_agregar = (Button)findViewById(R.id.bnt_agregar);
        btn_editar = (Button)findViewById(R.id.btn_editar);
        btn_eliminar = (Button)findViewById(R.id.btn_eliminar);

        //intent para ir a la actividad AgregarCursos
        btn_agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentReg = new Intent(cursos.this, agregar_cursos.class);
                cursos.this.startActivity(intentReg);
            }
        });


        lv_cursos = (ListView)findViewById(R.id.lista_cursos);
        listaCursos = daoUsuario.llenar_Cursos();
        adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_activated_1, listaCursos);
        lv_cursos.setAdapter(adaptador);
    }
}
