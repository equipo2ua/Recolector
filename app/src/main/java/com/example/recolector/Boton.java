package com.example.recolector;

import android.content.Context;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.core.content.ContextCompat;

    public class Boton extends  androidx.appcompat.widget.AppCompatButton {

    Boton btn;
    LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);

    public Boton(Context context) {
        super(context);
        config();
    }

    void config(){
        this.setLayoutParams(lp);
        this.setWidth(100);
        this.setBackground(getResources().getDrawable(R.color.primaryColor));
        this.setTextColor(ContextCompat.getColor(this.getContext(), R.color.cardview_light_background));

    }

    void getButton(String nameButton,int ID){

        this.setId(ID);
        this.setText(nameButton);


    }



}
