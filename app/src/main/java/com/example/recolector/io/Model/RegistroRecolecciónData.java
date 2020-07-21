package com.example.recolector.io.Model;

import com.google.gson.annotations.SerializedName;


public class RegistroRecolecciónData {

    @SerializedName("nombre")
    private String nombre;

    @SerializedName("apellido")
    private String apellido;

    @SerializedName("correo")
    private String correo;

    @SerializedName("telefono")
    private String telefono;

    @SerializedName("comuna")
    private String comuna;

    @SerializedName("calleYnumero")
    private String calleYnumero;

    @SerializedName("password")
    private String password;

    @SerializedName("repetirContraseña")
    private String repetirContraseña;

    public RegistroRecolecciónData(String nombre, String apellido, String correo, String telefono, String comuna, String calleYnumero, String password, String repetirContraseña){


        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
        this.comuna = comuna;
        this.calleYnumero = calleYnumero;
        this.password = password;
        this.repetirContraseña = repetirContraseña;




    }



}
