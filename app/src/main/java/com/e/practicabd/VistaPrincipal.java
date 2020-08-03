package com.e.practicabd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class VistaPrincipal extends AppCompatActivity {


    Button btn_profile, btn_education, btn_retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_principal);



        btn_profile = (Button) findViewById(R.id.btn_profile);
        btn_education = (Button) findViewById(R.id.btn_education);
        btn_retrofit = (Button) findViewById(R.id.btn_retrofit);

        //intent para ir a la actividad LISTA USUARIOS
        btn_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentReg = new Intent(VistaPrincipal.this, lista_de_usuarios.class);
                VistaPrincipal.this.startActivity(intentReg);
            }
        });

        //intent para ir a la actividad Cursos
        btn_education.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentReg = new Intent(VistaPrincipal.this, cursos.class);
                VistaPrincipal.this.startActivity(intentReg);
            }
        });

        //intent para ir a la actividad Retrofit
        btn_retrofit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentReg = new Intent(VistaPrincipal.this, retrofit.class);
                VistaPrincipal.this.startActivity(intentReg);
            }
        });

    }

    //METODO PARA MOSTRAR Y OCULTAR EL MENU
   public boolean onCreateOptionsMenu(Menu mimenu){
        getMenuInflater().inflate(R.menu.menu_activity_principal, mimenu);
        return true;
    }

    //METODO PARA ASIGNAR LAS FUNCIONES A LAS OPCIONES DEL MENU
    public boolean onOptionsItemSelected(MenuItem item){

        int id = item.getItemId();

        if (id == R.id.item1){
            Toast.makeText(VistaPrincipal.this, "opcion 1", Toast.LENGTH_SHORT).show();
        } else if(id == R.id.item2){
            Toast.makeText(VistaPrincipal.this, "opcion 2", Toast.LENGTH_SHORT).show();
        } else if(id == R.id.item3){
            Toast.makeText(VistaPrincipal.this, "opcion 3", Toast.LENGTH_SHORT).show();
        }
            return super.onOptionsItemSelected(item);
    }







}
