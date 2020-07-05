package com.example.recolector;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class IniciarSesion  extends AppCompatActivity {

    Intent intencion;
    TextView registrarse;
    TextView forgotPassword;

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

        //ejemplo dinamico
       // ejemplo = new TextView(this);
        //ejemplo.setText("wena los k");

        //container = (LinearLayout) findViewById(R.id.contenedor);

        Boton btn = new Boton(this);
        btn.getButton("dato curioso",1313);
        container.addView(btn);

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

             }
         }
     };



}
