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
import com.example.recolector.io.Model.DeserializarRecolector;
import com.example.recolector.io.Model.IniciarSessionData;
import com.example.recolector.io.Response.ApiAdapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class IniciarSesion  extends AppCompatActivity {

    Intent intencion;
    TextView forgotPassword;
    Button iniciarSesion, registrarse;
    EditText nombreSesion,contraseñaSesion;
    //ejemplo dinámico
   // TextView ejemplo;
    LinearLayout container;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.iniciar_sesion_recolector);
        registrarse = (Button) findViewById(R.id.IS_registrarse);
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

                     //comprobar si los campos estan vacíos

                      if(nombreSesion.getText().toString().equals("") || contraseñaSesion.getText().toString().equals("")){


                          // manda mensaje que no hay campos vacíos
                          Toast.makeText(IniciarSesion.this,"Los campos no pueden ser vacíos",Toast.LENGTH_SHORT).show();

                      }else{

                          IniciarSessionData sessionData = new IniciarSessionData(nombreSesion.getText().toString(),contraseñaSesion.getText().toString());

                          Call<List> call = ApiAdapter.getApiService().postSesionRecolector("basic V2VuYWFhYToxMjM0",sessionData);

                          call.enqueue(new Callback<List>() {
                              @Override
                              public void onResponse(Call<List> call, Response<List> response) {
                                  if(response.isSuccessful()){

                                      intencion = new Intent(IniciarSesion.this,Inicio.class);
                                      startActivity(intencion);

                                  }else{

                                      if(response.code() == 400){
                                          //el correo no existe
                                            if (true){
                                                Toast.makeText(IniciarSesion.this,"EL CORREO NO EXISTE O FORMATO INCORRECTO",Toast.LENGTH_SHORT).show();
                                            }else{

                                                Toast.makeText(IniciarSesion.this,"CONTRASEÑA INCORRECTA",Toast.LENGTH_SHORT).show();
                                            }

                                          Log.d("longitud","");


                                      }

                                  }
                              }

                              @Override
                              public void onFailure(Call<List> call, Throwable t) {

                                  // llega aquí cuando se equivoca en los datos de usuario
                                  Toast.makeText(IniciarSesion.this,"Usuario o Contraseña incorrectos",Toast.LENGTH_SHORT).show();



                              }
                          });


                          // intencion = new Intent(IniciarSesion.this,Inicio.class);
                          //startActivity(intencion);


                      }break;



             }
         }
     };




}
