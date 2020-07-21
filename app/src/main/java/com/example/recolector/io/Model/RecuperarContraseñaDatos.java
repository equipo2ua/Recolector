package com.example.recolector.io.Model;

import com.google.gson.annotations.SerializedName;

public class RecuperarContraseñaDatos {

    @SerializedName("correo")
    private String correo;

    public RecuperarContraseñaDatos(String correo){

        this.correo = correo;

    }

}
