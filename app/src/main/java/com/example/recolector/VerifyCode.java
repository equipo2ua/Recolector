package com.example.recolector;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class VerifyCode extends AppCompatActivity {

    Intent intencion;
    Button boton;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.verify_code);
        boton = (Button) findViewById(R.id.cancelar);
        boton.setOnClickListener(Listen);
        btn = (Button) findViewById(R.id.verificar);
        btn.setOnClickListener(Listen);
    }
    View.OnClickListener Listen = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.cancelar:
                    intencion = new Intent(com.example.recolector.VerifyCode.this, IniciarSesion.class);
                    startActivity(intencion);
                    break;
                case R.id.verificar:
                    intencion = new Intent(com.example.recolector.VerifyCode.this, ChangePassword.class);
                    startActivity(intencion);
                    break;
            }
        }
    };
}
