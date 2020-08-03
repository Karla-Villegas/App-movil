package com.e.practicabd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    TextView tv_registrar;

    Button btn_Inicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_registrar = (TextView)findViewById(R.id.tv_reg);

        final daoUsuario daoUsuario = new daoUsuario(getApplicationContext());


        tv_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentReg = new Intent(MainActivity.this, Main2Activity.class);
                MainActivity.this.startActivity(intentReg);
            }
        });




        btn_Inicio = (Button)findViewById(R.id.btn_Inicio);

        btn_Inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText txt_Usuario = (EditText)findViewById(R.id.txt_Usuario);
                EditText txt_Contraseña = (EditText)findViewById(R.id.txt_Contraseña);


                Cursor cursor = daoUsuario.ConsultarUserPass(txt_Usuario.getText().toString(), txt_Contraseña.getText().toString());

                if (cursor.getCount()> 0){
                    Intent i = new Intent(MainActivity.this, VistaPrincipal.class);
                    MainActivity.this.startActivity(i);
                }else{
                    Toast.makeText(getApplicationContext(), "usuario y/o password incorrectos", Toast.LENGTH_LONG).show();
                }

                txt_Usuario.setText("");
                txt_Contraseña.setText("");
                txt_Usuario.findFocus();


            }
        });


    }
}


