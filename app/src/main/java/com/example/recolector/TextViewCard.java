package com.example.recolector;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;

public class TextViewCard extends LinearLayout {

    private TextView idSolicitud, distance , dateSolicitud;


    public TextViewCard(Context context) {
        super(context);
        initChilds();

    }


    public TextViewCard(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initChilds();
    }
    private void initChilds(){
        distance = new TextView(getContext());
        idSolicitud = new TextView(getContext());
        dateSolicitud = new TextView(getContext());
        distance.setGravity(Gravity.LEFT);
        idSolicitud.setGravity(Gravity.LEFT);
        dateSolicitud.setGravity(Gravity.LEFT);
        addView(distance);
        addView(idSolicitud);
        addView(dateSolicitud);
    }

    private void setAppearence(){

    }

    public void setCardText(int id, int dist, String date){
        idSolicitud.setText(String.valueOf(id));
        distance.setText(String.valueOf(dist));
        dateSolicitud.setText(date);
    }
}
