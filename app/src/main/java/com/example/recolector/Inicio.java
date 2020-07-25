package com.example.recolector;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.recolector.io.Model.Solicitud;
import com.example.recolector.io.Response.ApiAdapter;
import com.example.recolector.io.Response.ApiService;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        Call<List> call = ApiAdapter.getSolicitudes().listSolicitudes("basic YWRtaW46YWRtaW4xMjM0==");
        call.enqueue(new Callback<List>() {
            @Override
            public void onResponse(Call<List> call, Response<List> response) {
                if(!response.isSuccessful()){
                    return;
                }

                List<Solicitud> getList= response.body();
                Gson gson = new Gson();
                String json = gson.toJson(getList);
                Solicitud[] list =  gson.fromJson(json,Solicitud[].class);

                for (Solicitud item : list) {
                    int km = 88;
                    int id = item.getId();
                    String fecha = item.getFecha_reciclaje();
                    fecha += fecha + " " + item.getHora_reciclaje();
                    String solicitud = "";


                    solicitud += "A " + km + "km \n";
                    solicitud += "Número de Solicitud " + id + "\n";
                    solicitud += "Fecha Solicitud " + fecha + "\n";
                    Log.d("Funciona", "" + solicitud);

                    cardSolicitud(solicitud);
                }


            }
            @Override
            public void onFailure(Call<List> call, Throwable t) {
                Log.d("Funciona","No funciona!!!!" + t);
            }
        });

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
