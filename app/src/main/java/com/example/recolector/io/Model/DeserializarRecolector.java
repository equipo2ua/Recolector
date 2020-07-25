package com.example.recolector.io.Model;

import java.util.List;

public class DeserializarRecolector {

    private int id;
    private String nombre_recolector;
    private String apellidoa_recolector;
    private String correo_recolector;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_recolector() {
        return nombre_recolector;
    }

    public void setNombre_recolector(String nombre_recolector) {
        this.nombre_recolector = nombre_recolector;
    }

    public String getApellidoa_recolector() {
        return apellidoa_recolector;
    }

    public void setApellidoa_recolector(String apellidoa_recolector) {
        this.apellidoa_recolector = apellidoa_recolector;
    }

    public String getCorreo_recolector() {
        return correo_recolector;
    }

    public void setCorreo_recolector(String correo_recolector) {
        this.correo_recolector = correo_recolector;
    }
}