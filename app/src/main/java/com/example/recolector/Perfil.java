package com.example.recolector;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.recolector.io.Model.DataRecolector;
import com.example.recolector.io.Response.ApiAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Perfil extends AppCompatActivity {
    private DrawerLayout drawerLayout;
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
        setToolbar();
        drawerLayout =findViewById(R.id.drawer_layout);
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
    private void setToolbar(){
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_home);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}