package com.example.sys.animation;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Delivery_address extends Fragment {
    Button Addaddress,Updateaddress;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate( R.layout.activity_delivery_address, container, false );
        Addaddress = view.findViewById( R.id.addaddress );
        Updateaddress = view.findViewById( R.id.updateadres );
        Addaddress.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), Add_new.class );
                startActivity( i );

            }
        } );
        Updateaddress.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), Update_new.class );
                startActivity( i );

            }
        } );
    return view;
    }}