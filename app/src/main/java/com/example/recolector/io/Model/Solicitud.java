package com.example.recolector.io.Model;

public class Solicitud {
    private int id;
    private int id_recolector;
    private int id_reciclador;
    private int id_reporte;
    private int peso_total_materiales;
    private int volumen_total_materiales;
    private String notificaciones_rechazadas;
    private int estado;
    private String hora_reciclaje;
    private String fecha_reciclaje;

    public int getId() {
        return id;
    }

    public int getId_recolector() {
        return id_recolector;
    }

    public int getId_reciclador() {
        return id_reciclador;
    }

    public int getId_reporte() {
        return id_reporte;
    }

    public int getPeso_total_materiales() {
        return peso_total_materiales;
    }

    public int getVolumen_total_materiales() {
        return volumen_total_materiales;
    }

    public String getNotificaciones_rechazadas() {
        return notificaciones_rechazadas;
    }

    public int getEstado() {
        return estado;
    }

    public String getHora_reciclaje() {
        return hora_reciclaje;
    }

    public String getFecha_reciclaje() {
        return fecha_reciclaje;
    }
}
