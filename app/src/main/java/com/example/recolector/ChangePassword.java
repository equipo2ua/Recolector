package com.example.recolector;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChangePassword extends AppCompatActivity {

    Intent intencion;
    Button boton;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_password);
        boton = (Button) findViewById(R.id.CPcancelar);
        boton.setOnClickListener(Listen);
        btn = (Button) findViewById(R.id.CPverificar);
        btn.setOnClickListener(Listen);
    }
    View.OnClickListener Listen = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.CPcancelar:
                    intencion = new Intent(com.example.recolector.ChangePassword.this, IniciarSesion.class);
                    startActivity(intencion);
                    break;
                case R.id.CPverificar:
                    intencion = new Intent(com.example.recolector.ChangePassword.this, IniciarSesion.class);
                    startActivity(intencion);
                    break;
            }
        }
    };
}
