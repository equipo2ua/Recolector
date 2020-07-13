package com.example.recolector;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Inicio extends AppCompatActivity {

    private ViewGroup listSolicitudes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        listSolicitudes = (ViewGroup) findViewById(R.id.card);
        getSolicitudes();

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

        solicitud += "A " + km +"km \n";
        solicitud += "Número de Solicitud " + id +"\n";
        solicitud += "Fecha Solicitud " + fecha +"\n";

        for(int i=0;i<20;i++){cardSolicitud(solicitud);}
    }
}
