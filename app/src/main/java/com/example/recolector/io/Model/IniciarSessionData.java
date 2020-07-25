package com.example.recolector.io.Model;


import com.google.gson.annotations.SerializedName;

public class IniciarSessionData {

    @SerializedName("nombre")
    private String nombre; //editext nombre

    @SerializedName("contraseña")
    private String contraseña;

    public IniciarSessionData(String nombre, String contraseña){

        this.nombre = nombre;
        this.contraseña = contraseña;
    }

}
