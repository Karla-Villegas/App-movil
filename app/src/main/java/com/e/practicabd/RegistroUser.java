package com.e.practicabd;

public class RegistroUser {


        int id;
        String nombre, usuario, contraseña, edad;


        public RegistroUser(){

        }

    public RegistroUser(String nombre, String usuario, String contraseña, String edad) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.edad = edad;
    }


    public boolean isNull(){

        if(nombre.equals("")&&usuario.equals("")&&contraseña.equals("")&&edad.equals("")){
            return false;
        }else {
            return true;
        }

    }


    @Override
    public String toString() {
        return "RegistroUser{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", usuario='" + usuario + '\'' +
                ", contraseña='" + contraseña + '\'' +
                ", edad='" + edad + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }
}
