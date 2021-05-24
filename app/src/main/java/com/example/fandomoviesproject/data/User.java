package com.example.fandomoviesproject.data;

public class User {

    private String nombreYapellidos;
    private String contraseña;
    private String email;
    private String numMovil;

    public User(String nombreYapellidos, String contraseña, String email, String numMovil) {
        this.nombreYapellidos = nombreYapellidos;
        this.contraseña = contraseña;
        this.email = email;
        this.numMovil = numMovil;
    }
    public String getNombreYapellidos() {
        return nombreYapellidos;
    }
    public String getContraseña() {
        return contraseña;
    }
    public String getEmail() {
        return email;
    }
    public String getNumMovil() {
        return numMovil;
    }


    public void setNombreYapellidos(String nombreYapellidos) {
        this.nombreYapellidos= nombreYapellidos;
    }
    public void setContraseña(String contraseña) {
        this.contraseña= contraseña;
    }
    public void setEmail(String email) {
        this.email= email;
    }
    public void setNumMovil(String numMovil) {
        this.numMovil= numMovil;
    }

}

