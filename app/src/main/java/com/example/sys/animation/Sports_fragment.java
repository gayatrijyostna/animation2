package com.example.sys.animation;


 import android.content.Intent;
 import android.os.Bundle;
 import android.support.annotation.NonNull;
 import android.support.annotation.Nullable;
 import android.support.v4.app.Fragment;
 import android.support.v7.widget.LinearLayoutManager;
 import android.support.v7.widget.RecyclerView;
 import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
 import android.view.WindowManager;
 import android.widget.ArrayAdapter;
 import android.widget.ImageView;
 import android.widget.LinearLayout;
 import android.widget.TextView;

public class Sports_fragment extends Fragment {
    LinearLayout bottom_cart_layout;
    TextView text_cart;
    ImageView back;
    private int total;
    String[] name = {"Tata salt 1kg", "Pineaapple-sllices", "Vim dish bar", "Maggie 2mins masal"};
    String[] cost = {"18", "19", "47", "47"};
    int[] img = {R.drawable.salt, R.drawable.fortune, R.drawable.vim, R.drawable.maggi};
    ArrayAdapter <String> adapter;
    Sprouts_recycler recycler;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getActivity().getWindow().setSoftInputMode( WindowManager.
                LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN );
        View view = inflater.inflate( R.layout.activity_sports_fragment, container, false );
        RecyclerView recyclerView1 = view.findViewById( R.id.recyclerview );
        Sprouts_recycler recyclerAdapter = new Sprouts_recycler( getActivity(), name, cost, img, new ClickListener() {
            @Override
            public void itemClick(View view, int pos, int quantity) {
                if (view.getId() == R.id.item_add) {
                    total = total + Integer.parseInt( cost[pos] );
                    bottom_cart_layout.setVisibility( View.VISIBLE );
                    text_cart.setText( "Add to Cart items \u20B9 " + total );
                    if (total == 0) {
                        bottom_cart_layout.setVisibility( View.GONE );
                    }
                } else if (view.getId() == R.id.item_sub) {
                    total = total - Integer.parseInt( cost[pos] );
                    bottom_cart_layout.setVisibility( View.VISIBLE );
                    text_cart.setText( "Add to databaseCart items " + total );
                    if (total == 0) {
                        bottom_cart_layout.setVisibility( View.GONE );
                    }
                }
            }
        } );


        getActivity().getWindow().setSoftInputMode( WindowManager.
                LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN );
        bottom_cart_layout = view.findViewById( R.id.bottom_cart_layout );
        text_cart = view.findViewById( R.id.cart_text );
        recyclerView1.setAdapter( recyclerAdapter );


        bottom_cart_layout.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent( getActivity(), CartActivity.class );
                i.putExtra( "CART", String.valueOf( total ) );
                startActivity( i );
            }
        } );

        return view;
    }

}


