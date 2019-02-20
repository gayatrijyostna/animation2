package com.example.sys.animation;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Checkout extends AppCompatActivity {
    LinearLayout bottom_cart_layout;
    TextView text_cart;
    private int total;

    RecyclerView recyclerView;
    int[] images = {R.drawable.salt, R.drawable.oil, R.drawable.vim};
    String[] imgname={"Tata Salt,1kg","Fortune Oil,1kg","Vim Bar"};
    String[] price={"Price:Rs.18","Price:Rs.52","Price:Rs.20"};
    String[] orderedtime={"Ordered on 04-oct-2017","Ordered on 04-oct-2017","Ordered on 04-oct-2017"};
    String[] review,reorder;

    ArrayAdapter<String> adapter;
    Recycler_myorder recycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_checkout );
        RecyclerView recyclerView1 =findViewById( R.id.recycler3 );
        recyclerView1.setLayoutManager( new LinearLayoutManager( Checkout.this ) );
        Recycler_myorder recyclerAdapter = new Recycler_myorder(Checkout.this,images,imgname,price,orderedtime,review,reorder,new ClickListener() {
            @Override
            public void itemClick(View view, int pos, int quantity) {
                if (view.getId() == R.id.item_add) {
                    total = total + Integer.parseInt(price[pos]);
                    bottom_cart_layout.setVisibility(View.VISIBLE);
                    text_cart.setText("Add to Cart items \u20B9 " + total);
                    if (total == 0) {
                        bottom_cart_layout.setVisibility(View.GONE);
                    }
                } else if (view.getId() == R.id.item_sub) {
                    total = total - Integer.parseInt(price[pos]);
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
