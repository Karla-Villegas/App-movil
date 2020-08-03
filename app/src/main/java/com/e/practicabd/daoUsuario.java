package com.e.practicabd;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class daoUsuario extends SQLiteOpenHelper {


    public static final String NOMBRE_BD = "db_hope";
    public static final int Version= 1;
    public static final String CREAR_TABLA_USUARIOS= "CREATE TABLE IF NOT EXISTS usuarios (nombre TEXT, usuario TEXT, contraseña TEXT, edad INTEGER)";
    public static final String CREAR_TABLA_CURSOS= "CREATE TABLE IF NOT EXISTS cursos (nombre TEXT, descripcion TEXT)";




    public daoUsuario(Context context) {
        super(context, NOMBRE_BD, null, Version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREAR_TABLA_USUARIOS);
        db.execSQL(CREAR_TABLA_CURSOS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //metodo para agregar usuarios
    public void AgreagarUser(String nombre, String usuario, String contraseña, String edad){

        SQLiteDatabase BaseDatos = getWritableDatabase();

        ContentValues valores = new ContentValues();

            valores.put("nombre", nombre);
            valores.put("usuario", usuario);
            valores.put("contraseña", contraseña);
            valores.put("edad", edad);

            BaseDatos.insert("usuarios", null, valores);

            BaseDatos.close();
    }

    //metodo para validar usuario
    public Cursor ConsultarUserPass(String usuario, String contraeña) throws SQLException{

        Cursor mcursor = null;

        mcursor = this.getReadableDatabase().query("usuarios", new String[]{"nombre", "usuario", "contraseña", "edad"},
                "usuario like '"+usuario+"' and contraseña like '"+contraeña+"'", null, null, null, null);

        return mcursor;
    }


    //metodo para agregar cursos
    public void AgreagarCursos(String nombre, String descripcion){

        SQLiteDatabase BaseDatos = getWritableDatabase();

        ContentValues valores = new ContentValues();

        valores.put("nombre", nombre);
        valores.put("descripcion", descripcion);

        BaseDatos.insert("cursos", null, valores);

        BaseDatos.close();
    }





    //metodo para llenar lista de usuarios
    public ArrayList llenar_lv(){
        ArrayList<String> lista = new ArrayList<>();
        SQLiteDatabase BaseDatos = this.getWritableDatabase();

        String q = "SELECT * FROM usuarios";
        Cursor registros = BaseDatos.rawQuery(q, null);

        if (registros.moveToFirst()){
            do {
                lista.add(registros.getString(1));
            }while (registros.moveToNext());
        }

        return lista;
    }

    //metodo para llenar lista de cursos
   public ArrayList llenar_Cursos(){

       ArrayList<String> listaCursos= new ArrayList<>();
       SQLiteDatabase BaseDatos = this.getWritableDatabase();


       String sql = "SELECT * FROM cursos";
       Cursor registroCursos = BaseDatos.rawQuery(sql, null);

       if (registroCursos.moveToFirst()){
           do {
               listaCursos.add(registroCursos.getString(1));
           }while (registroCursos.moveToNext());
       }


        return listaCursos;
   }



}
