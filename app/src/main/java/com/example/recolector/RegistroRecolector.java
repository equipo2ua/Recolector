package com.example.recolector;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.recolector.io.Model.RegistroRecolecciónData;
import com.example.recolector.io.Response.ApiAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistroRecolector extends AppCompatActivity {

    Intent intencion;
    Button btnCancelarInventario, btnRegistrarse;
    EditText nombre,apellido,correo,telefono,comuna,calleYnumero,password,repetirpassword;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro_recolector);

        btnCancelarInventario = (Button) findViewById(R.id.FormCancelarButton);
        btnCancelarInventario.setOnClickListener(Listen);
        btnRegistrarse = (Button) findViewById(R.id.FormRegistrarseButton);
        btnRegistrarse.setOnClickListener(Listen);

    }

    View.OnClickListener Listen = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch (v.getId()){

                case R.id.FormCancelarButton:
                    intencion = new Intent(RegistroRecolector.this,IniciarSesion.class);
                    startActivity(intencion);
                    break;
                case R.id.FormRegistrarseButton:

                    nombre = (EditText) findViewById(R.id.FormNombre);
                    apellido = (EditText) findViewById(R.id.FormApellido);
                    correo = (EditText) findViewById(R.id.FormCorreo);
                    telefono = (EditText) findViewById(R.id.FormTelefono);
                    comuna = (EditText) findViewById(R.id.FormComuna);
                    calleYnumero = (EditText) findViewById(R.id.FormCalle);
                    password = (EditText) findViewById(R.id.FormContraseña);
                    repetirpassword = (EditText) findViewById(R.id.FormRepetirContraseña);

                    if(     nombre.getText().toString().equals("") || apellido.getText().toString().equals("") ||
                            repetirpassword.getText().toString().equals("") ||correo.getText().toString().equals("") ||
                            password.getText().toString().equals("") ||telefono.getText().toString().equals("") ||
                            calleYnumero.getText().toString().equals("") ||comuna.getText().toString().equals("") ){


                        Toast.makeText(RegistroRecolector.this,"debes completar todos los campos",Toast.LENGTH_LONG).show();

                    }else{

                        RegistroRecolecciónData registroRecolecciónData = new RegistroRecolecciónData(
                                nombre.getText().toString(),
                                apellido.getText().toString(),
                                correo.getText().toString(),
                                telefono.getText().toString(),
                                comuna.getText().toString(),
                                calleYnumero.getText().toString(),
                                password.getText().toString(),
                                repetirpassword.getText().toString()
                        );

                        Call<List> call = ApiAdapter.getApiService().postRegistrarRecolector("basic aGFuZHk6aGFuZHl4MTk5OA==",registroRecolecciónData);

                        call.enqueue(new Callback<List>() {
                            @Override
                            public void onResponse(Call<List> call, Response<List> response) {
                                if(response.isSuccessful()){

                                    Log.d("funcionandooo","tamosgud" );
                                    intencion = new Intent(RegistroRecolector.this,IniciarSesion.class);
                                    startActivity(intencion);
                                }
                            }

                            @Override
                            public void onFailure(Call<List> call, Throwable t) {
                                Log.d("onfailcall",""+t );
                            }
                        });

                    }break;



            }
        }
    };

}
