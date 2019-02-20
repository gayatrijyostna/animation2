package com.example.sys.animation;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;

public class Recycler_checkout extends RecyclerView.Adapter<Recycler_checkout.MyViewHolder> {
    Context context;
    int[] images;
    String[] imgname;
    String[] price;
    String[] orderedtime;
    String[] remove;
    TextView  quantity;
    TextView  plus, minus;
    int sum;


    private ClickListener clickListener;
    public Recycler_checkout(Context Checkout, int[] images, String[] imgname, String[] price, String[] orderedtime, String[] remove) {
        context = Checkout;
        this.images = images;
        this.clickListener= this.clickListener;
        this.imgname = imgname;
        this.price = price;
        this.orderedtime = orderedtime;
        this.remove = remove;


    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from( context ).inflate( R.layout.activity_recycler_checkout, viewGroup, false );
//        Recycler_checkout.ViewHolderClass viewHolderClass = new Recycler_checkout.ViewHolderClass( view );
        return new  MyViewHolder(view, clickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder MyViewHolder, int i) {
        MyViewHolder.imageView.setImageResource( images[i] );
        MyViewHolder.txtview.setText( imgname[i] );
        MyViewHolder.txtview1.setText( price[i] );
        MyViewHolder.txtview2.setText( orderedtime[i] );
        MyViewHolder.remove.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        } );


    }


    @Override
    public int getItemCount() {
        return images.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView txtview;
        TextView txtview1;
        TextView txtview2;
        TextView remove;


        TextView plus, minus;
        TextView count, name, single_price, price;
        CardView layout_cart;

        int sum;
        int single_item_price;

        public MyViewHolder(@NonNull View itemView, final ClickListener listener) {
            super( itemView );


            count = itemView.findViewById( R.id.tv_quantity );

            plus = itemView.findViewById( R.id.item_add );
            minus = itemView.findViewById( R.id.item_sub );
            plus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sum = sum + 1;
                    Log.e("Quantity value 2 ", "" + sum);
                    if (sum > 0) {
                        quantity.setVisibility(View.VISIBLE);
                        minus.setVisibility(View.VISIBLE);
                    }
                    quantity.setText(String.valueOf(sum));
                    listener.itemClick(view, getAdapterPosition(), sum);
                }
            });

            minus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (sum > 0) {
                        sum = sum - 1;
                        if (sum == 0) {
                            quantity.setVisibility(View.INVISIBLE);
                            minus.setVisibility(View.INVISIBLE);
                        }
                        quantity.setText(String.valueOf(sum));
                        listener.itemClick(view, getAdapterPosition(), sum);
                    }
                }
            });


            }
    }

}