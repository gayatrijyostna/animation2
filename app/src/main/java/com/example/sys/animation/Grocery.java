package com.example.sys.animation;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;

public class Grocery extends AppCompatActivity {
        RecyclerView recyclerView;
        int[] images = {R.drawable.fruits, R.drawable., R.drawable.femalepf1,R.drawable.perfume2,R.drawable.pf4,R.drawable.pf7};

        ArrayAdapter<String> adapter;
        Recycler_grocery recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
    }
}
