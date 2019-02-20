package com.example.sys.animation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Bevarages extends AppCompatActivity {
    LinearLayout bottom_cart_layout;
    TextView text_cart;
    private int total;


    RecyclerView recyclerView;
    ImageView filter;
    String[] arr = {"Tata salt 1kg", "Fortune oil 1lt", "Vim dish bar", "Maggie 2mins masal"};
    String[] arr1 = {"Rs 18", "Rs 19", "Rs 47", "Rs 47"};
    int[] img = {R.drawable.salt, R.drawable.fortune, R.drawable.vim, R.drawable.maggi};
    ArrayAdapter<String> adapter;
    Recycler_bevarages recycler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_bevarages );
        RecyclerView recyclerView1 = findViewById(R.id.recycle);

        recyclerView1.setLayoutManager( new LinearLayoutManager( this ) );
        Recycler_bevarages recyclerAdapter = new Recycler_bevarages(Bevarages.this, arr, arr1, img, new ClickListener() {
            @Override
            public void itemClick(View view, int pos, int quantity) {
                if (view.getId() == R.id.item_add) {
                    total = total + Integer.parseInt(arr1[pos]);
                    bottom_cart_layout.setVisibility(View.VISIBLE);
                    text_cart.setText("Add to Cart items \u20B9 " + total);
                    if (total == 0) {
                        bottom_cart_layout.setVisibility(View.GONE);
                    }
                } else if (view.getId() == R.id.item_sub) {
                    total = total - Integer.parseInt(arr1[pos]);
                    bottom_cart_layout.setVisibility(View.VISIBLE);
                    text_cart.setText("Add to databaseCart items " + total);
                    if (total == 0) {
                        bottom_cart_layout.setVisibility(View.GONE);
                    }
                }
            }
        });

      getWindow().setSoftInputMode(WindowManager.
                LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        bottom_cart_layout = findViewById(R.id.bottom_cart_layout);
        text_cart = findViewById(R.id.cart_text);
        recyclerView1.setAdapter(recyclerAdapter);
    }

    }
