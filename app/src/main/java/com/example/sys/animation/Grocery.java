package com.example.sys.animation;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;

public class Grocery extends AppCompatActivity {
        RecyclerView recyclerView;
        int[] images = {R.drawable.fruits, R.drawable.bread, R.drawable.bevarages2,R.drawable.fruits,R.drawable.bread,R.drawable.bevarages2};
        String[] arr={"Fruits and vegetables","Bread,Dairy and Eggs","Bevarages","Personal Care","Fruits and vegetables","Bread,Dairy and Eggs","Bevarages","Personal Care"};

        ArrayAdapter<String> adapter;
        Recycler_grocery recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
            RecyclerView recyclerView1 = findViewById( R.id.recycler3 );
            recyclerView1.setLayoutManager( new GridLayoutManager( this,2 ) );
            Recycler_grocery recyclerAdapter = new Recycler_grocery( this, arr,images);
            recyclerView1.setAdapter( recyclerAdapter );

        }
}
