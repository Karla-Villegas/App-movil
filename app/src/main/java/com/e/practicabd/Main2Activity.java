package com.e.practicabd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    EditText txt_RegNombre, txt_RegUsuario, txt_RegContraseña, txt_RegEdad;
    Button btn_registrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txt_RegNombre = (EditText)findViewById(R.id.txt_RegNombre);
        txt_RegUsuario = (EditText)findViewById(R.id.txt_RegUsuario);
        txt_RegContraseña = (EditText)findViewById(R.id.txt_RegContraseña);
        txt_RegEdad  = (EditText)findViewById(R.id.txt_RegEdad);

        btn_registrar = (Button)findViewById(R.id.btn_registrar);


        final daoUsuario daoUsuario = new daoUsuario(getApplicationContext());

        btn_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                daoUsuario.AgreagarUser(txt_RegNombre.getText().toString(), txt_RegUsuario.getText().toString(), txt_RegContraseña.getText().toString(), txt_RegEdad.getText().toString());
                Toast.makeText(Main2Activity.this, "agregado correctamente", Toast.LENGTH_LONG).show();

                Intent i = new Intent(Main2Activity.this, MainActivity.class);
                Main2Activity.this.startActivity(i);
            }
        });

    }
}
