package com.e.practicabd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class lista_de_usuarios extends AppCompatActivity {


    ListView lv;
    ArrayList<String> lista;
    ArrayAdapter adaptador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_de_usuarios);

        final daoUsuario daoUsuario = new daoUsuario(getApplicationContext());

        lv = (ListView)findViewById(R.id.lista);
        lista = daoUsuario.llenar_lv();
        adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_activated_1, lista);
        lv.setAdapter(adaptador);

    }

// () {}
}

