package com.e.practicabd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class agregar_cursos extends AppCompatActivity {

    Button btn_agregarCurso;
    EditText txt_RegNombreCurso, txt_RegDescripcionCurso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_cursos);


        btn_agregarCurso = (Button)findViewById(R.id.btn_agregarCurso);
        txt_RegNombreCurso = (EditText)findViewById(R.id.txt_RegNombreCurso);
        txt_RegDescripcionCurso = (EditText)findViewById(R.id.txt_RegDescripcionCurso);


        final daoUsuario daoUsuario = new daoUsuario(getApplicationContext());

        btn_agregarCurso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                daoUsuario.AgreagarCursos(txt_RegNombreCurso.getText().toString(), txt_RegDescripcionCurso.getText().toString());
                Toast.makeText(agregar_cursos.this, "curso agregado correctamente", Toast.LENGTH_LONG).show();

                Intent i = new Intent(agregar_cursos.this, cursos.class);
                agregar_cursos.this.startActivity(i);
            }
        });

    }
}
