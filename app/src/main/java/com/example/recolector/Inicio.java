package com.example.recolector;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

public class Inicio extends AppCompatActivity {

    private ViewGroup listSolicitudes;
    private LinearLayout encabezado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        listSolicitudes = (ViewGroup) findViewById(R.id.card);
        encabezado = (LinearLayout) findViewById(R.id.header);
        getUser();
        getSolicitudes();

    }
    private void setEncabezado(String name, float rating, String statisticsUser){
        LayoutInflater inflater = LayoutInflater.from(this);
        int id = R.layout.encabezado_inicio;

        LinearLayout linearLayout = (LinearLayout) inflater.inflate(id, null, false);

        TextView textCard = (TextView) linearLayout.findViewById(R.id.hiUser);
        textCard.setText(String.valueOf(name));
        RatingBar ratingBar = (RatingBar) linearLayout.findViewById(R.id.rating);
        ratingBar.setRating(rating);
        TextView statistics = (TextView) linearLayout.findViewById(R.id.statistics);
        statistics.setText(statisticsUser);

        encabezado.addView(linearLayout);
    }

    private void cardSolicitud(String detail){
        LayoutInflater inflater = LayoutInflater.from(this);
        int id = R.layout.activity_card;

        LinearLayout linearLayout = (LinearLayout) inflater.inflate(id, null, false);
        TextView textCard = (TextView) linearLayout.findViewById(R.id.textVariable);
        textCard.setText(String.valueOf(detail));

        listSolicitudes.addView(linearLayout);
    }

    private void getSolicitudes(){
        /*Esta funcionalidad está a la espera de la
        habilitación del backend para ser modificada*/
        int km = 21;
        int id = 2055541;
        String fecha = "28/08/2019 13:59";
        String solicitud = "";

        /* Lo siguiente debe ser la forma de enviar los datos*/
        solicitud += "A " + km +"km \n";
        solicitud += "Número de Solicitud " + id +"\n";
        solicitud += "Fecha Solicitud " + fecha +"\n";
        /*Hasta aca!*/
        for(int i=0;i<6;i++){cardSolicitud(solicitud);}
    }
    private void getUser(){
        /*Esta funcionalidad está a la espera de la
        habilitación del backend para ser modificada*/
        String name = "Andrés";
        int travel = 38;
        int time = 25;
        int distance = 34;
        float rating = (float) 4.5;

        String nameText = "";
        String statistics = "";
        /* Lo siguiente debe ser la forma de enviar los datos*/
        nameText += "¡Hola " + name +"!\n";
        statistics += "Viajes " + travel +"\n";
        statistics += "Tiempo " + time +" hrs\n";
        statistics += "Distancia " + distance +" Km\n\n";
        /*Hasta aca!*/
        setEncabezado(nameText,rating,statistics);
    }
}
