package com.example.recolector;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DetalleSolicitud extends AppCompatActivity {

    TextView StateTextView,
            RequestNumberTextView,
            RequestDateTextView,
            NameTextView,
            PhoneNumberTextView,
            RatingTextView,
            AddressTextView,
            DistrictTextView,
            CityTextView;
    Button  DenyButton,
            AcceptButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_solicitud);

        StateTextView = (TextView) findViewById(R.id.StateTextView);
        RequestNumberTextView = (TextView) findViewById(R.id.RequestNumberTextView);
        RequestDateTextView = (TextView) findViewById(R.id.RequestDateTextView);
        NameTextView = (TextView) findViewById(R.id.NameTextView);
        PhoneNumberTextView = (TextView) findViewById(R.id.PhoneNumberTextView);
        RatingTextView = (TextView) findViewById(R.id.RatingTextView);
        AddressTextView = (TextView) findViewById(R.id.AddressTextView);
        DistrictTextView = (TextView) findViewById(R.id.DistrictTextView);
        CityTextView = (TextView) findViewById(R.id.CityTextView);

        DenyButton = (Button) findViewById(R.id.DenyButton);
        AcceptButton = (Button) findViewById(R.id.AcceptButton);

        DenyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DetalleSolicitud.this,"Esta funcion aun no es valida",Toast.LENGTH_SHORT);
            }
        });

        AcceptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DetalleSolicitud.this,"Esta funcion aun no es valida",Toast.LENGTH_SHORT);
            }
        });

    }
}