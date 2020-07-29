package com.example.recolector;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.recolector.io.Model.DataRecolector;
import com.example.recolector.io.Response.ApiAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Perfil extends AppCompatActivity {
    private int idRecolector;
    private RatingBar calif;
    private TextView name;
    private TextView lastName;
    private TextView address;
    private TextView gender;
    private TextView phone;
    private TextView email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        idRecolector = getIntent().getExtras().getInt("recolector");
        getProfile();
        calif = (RatingBar) findViewById(R.id.rating);
        name =(TextView) findViewById(R.id.Profilename);
        lastName =(TextView) findViewById(R.id.ProfilelastName);
        address = (TextView) findViewById(R.id.Profileaddress);
        gender =(TextView) findViewById(R.id.Profilegender);
        phone = (TextView) findViewById(R.id.Profilephone);
        email =(TextView) findViewById(R.id.ProfileEmail);

    }

    private void getProfile(){
        DataRecolector dataRecolector =new DataRecolector(idRecolector);
        Call<List<DataRecolector>> call = ApiAdapter.getApiService().getRecolector("basic YWRtaW5pc3RyYWRvcjphZG1pbmlzdHJhZG9y", dataRecolector);
        call.enqueue(new Callback<List<DataRecolector>>() {
            @Override
            public void onResponse(Call<List<DataRecolector>> call, Response<List<DataRecolector>> response) {
                if(!response.isSuccessful()){
                    return;
                }
                List<DataRecolector> body = response.body();
                for(DataRecolector p: body){
                    calif.setRating(p.getCalificacion_recolector());
                    name.setText(p.getNombre_recolector());
                    lastName.setText(p.getApellido_recolector());
                    address.setText(p.getCorreo_recolector());
                    gender.setText("No definido");
                    phone.setText(p.getTelefono_recolector());
                    email.setText(p.getCorreo_recolector());
                }

            }

            @Override
            public void onFailure(Call<List<DataRecolector>> call, Throwable t) {

            }
        });
    }
}