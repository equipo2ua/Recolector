package com.example.recolector;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class RegistroRecolector extends AppCompatActivity {

    Intent intencion;
    Button btn;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro_recolector);

        btn = (Button) findViewById(R.id.FormCancelarButton);
        btn.setOnClickListener(Listen);

    }

    View.OnClickListener Listen = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch (v.getId()){

                case R.id.FormCancelarButton:
                    intencion = new Intent(RegistroRecolector.this,IniciarSesion.class);
                    startActivity(intencion);
                    break;

            }
        }
    };

}
