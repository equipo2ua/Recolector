package com.example.recolector;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.recolector.io.Model.IniciarSessionData;
import com.example.recolector.io.Response.ApiAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class IniciarSesion  extends AppCompatActivity {

    Intent intencion;
    TextView registrarse;
    TextView forgotPassword;
    Button iniciarSesion;
    EditText nombreSesion,contraseñaSesion;
    //ejemplo dinámico
   // TextView ejemplo;
    LinearLayout container;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.iniciar_sesion_recolector);
        registrarse = (TextView) findViewById(R.id.IS_registrarse);
        registrarse.setOnClickListener(Listen);
        forgotPassword = (TextView) findViewById(R.id.forgotPassword);
        forgotPassword.setOnClickListener(Listen);

        iniciarSesion = (Button) findViewById(R.id.IS_iniciarSesionButton);
        iniciarSesion.setOnClickListener(Listen);





    }


     final View.OnClickListener Listen = new View.OnClickListener() {
         @Override
         public void onClick(View v) {

             switch (v.getId()){

                 case R.id.IS_registrarse:
                     intencion = new Intent(IniciarSesion.this,RegistroRecolector.class);
                     startActivity(intencion);
                     break;
                 case R.id.forgotPassword:
                     intencion = new Intent(IniciarSesion.this,ForgotPassword.class);
                     startActivity(intencion);
                     break;
                 case R.id.IS_iniciarSesionButton:


                     nombreSesion = (EditText) findViewById(R.id.IS_nombre);
                     contraseñaSesion = (EditText) findViewById(R.id.IS_contraseña);

                     IniciarSessionData sessionData = new IniciarSessionData(nombreSesion.getText().toString(),contraseñaSesion.getText().toString());

                     Call<List> call = ApiAdapter.getApiService().postSesionRecolector("basic aGFuZHk6aGFuZHl4MTk5OA==",sessionData);

                     call.enqueue(new Callback<List>() {
                         @Override
                         public void onResponse(Call<List> call, Response<List> response) {
                             if(response.isSuccessful()){
                                 Toast.makeText(IniciarSesion.this,"funciona",Toast.LENGTH_LONG).show();
                                // Intent ir_a_inicio = new Intent(IniciarSesion.this,Inicio.class);
                                 //startActivity(ir_a_inicio);

                             }
                         }

                         @Override
                         public void onFailure(Call<List> call, Throwable t) {

                             Log.d("cagada",""+t);
                             Toast.makeText(IniciarSesion.this,"cagueloni",Toast.LENGTH_LONG).show();
                         }
                      });


                    // intencion = new Intent(IniciarSesion.this,Inicio.class);
                     //startActivity(intencion);
                     break;

             }
         }
     };



}
