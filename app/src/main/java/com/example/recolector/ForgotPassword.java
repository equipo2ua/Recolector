package com.example.recolector;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


    public class ForgotPassword extends AppCompatActivity {
        Intent intencion;
        Button boton;
        Button btn;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.recuperar_cuenta);
            boton = (Button) findViewById(R.id.RCCancelar);
            boton.setOnClickListener(Listen);
            btn = (Button) findViewById(R.id.RCEnviar);
            btn.setOnClickListener(Listen);
        }

        View.OnClickListener Listen = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.RCCancelar:
                        intencion = new Intent(com.example.recolector.ForgotPassword.this, IniciarSesion.class);
                        startActivity(intencion);
                        break;
                    case R.id.RCEnviar:
                        intencion = new Intent(com.example.recolector.ForgotPassword.this, VerifyCode.class);
                        startActivity(intencion);
                        break;
                }
            }
        };
    }

