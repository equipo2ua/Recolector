package com.example.recolector.io.Model;

public class DataRecolector {

    private int id;
    private String nombre_recolector;
    private String apellido_recolector;
    private String correo_recolector;
    private String telefono_recolector;
    private String n_documento_recolector;
    private int calificacion_recolector;
    private String estado;
    private int cantidad_calificaciones;
    private int suma_calificaciones;

    public DataRecolector(int id, String nombre_recolector, String apellido_recolector, String correo_recolector, String telefono_recolector, String n_documento_recolector, int calificacion_recolector, String estado, int cantidad_calificaciones, int suma_calificaciones) {
        this.id = id;
        this.nombre_recolector = nombre_recolector;
        this.apellido_recolector = apellido_recolector;
        this.correo_recolector = correo_recolector;
        this.telefono_recolector = telefono_recolector;
        this.n_documento_recolector = n_documento_recolector;
        this.calificacion_recolector = calificacion_recolector;
        this.estado = estado;
        this.cantidad_calificaciones = cantidad_calificaciones;
        this.suma_calificaciones = suma_calificaciones;
    }

    public DataRecolector(int id){
        this.id = id;
    }


    public int getId() {
        return id;
    }

    public String getNombre_recolector() {
        return nombre_recolector;
    }

    public String getApellido_recolector() {
        return apellido_recolector;
    }

    public String getCorreo_recolector() {
        return correo_recolector;
    }

    public String getTelefono_recolector() {
        return telefono_recolector;
    }

    public String getN_documento_recolector() {
        return n_documento_recolector;
    }

    public int getCalificacion_recolector() {
        return calificacion_recolector;
    }

    public String getEstado() {
        return estado;
    }

    public int getCantidad_calificaciones() {
        return cantidad_calificaciones;
    }

    public int getSuma_calificaciones() {
        return suma_calificaciones;
    }

}
