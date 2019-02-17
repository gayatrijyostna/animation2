package com.example.sys.animation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Delivery_address extends AppCompatActivity {
    Button Addaddress,Updateaddress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_delivery_address );
        Addaddress=findViewById( R.id.addaddress);
        Updateaddress=findViewById(R.id.updateadres);
        Addaddress.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Delivery_address.this, Add_new.class);
                startActivity(i);

            }
});
        Updateaddress.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Delivery_address.this, Update_new.class);
                startActivity(i);

            }
        });
    }}