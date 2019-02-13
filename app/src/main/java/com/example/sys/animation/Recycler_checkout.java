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

public class Recycler_checkout extends RecyclerView.Adapter<Recycler_checkout.ViewHolderClass> {
    Context context;
    int[] images;
    String[] imgname;
    String[] price;
    String[] orderedtime;
    String[] remove;


    public Recycler_checkout(Context Checkout, int[] images, String[] imgname, String[] price, String[] orderedtime, String[] remove) {
        context = Checkout;
        this.images = images;
        this.imgname = imgname;
        this.price = price;
        this.orderedtime = orderedtime;
        this.remove = remove;


    }

    @NonNull
    @Override
    public Recycler_checkout.ViewHolderClass onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from( context ).inflate( R.layout.activity_recycler_checkout, viewGroup, false );
        Recycler_checkout.ViewHolderClass viewHolderClass = new Recycler_checkout.ViewHolderClass( view );
        return viewHolderClass;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderClass viewHolderClass, int i) {
        viewHolderClass.imageView.setImageResource( images[i] );
        viewHolderClass.txtview.setText( imgname[i] );
        viewHolderClass.txtview1.setText( price[i] );
        viewHolderClass.txtview2.setText( orderedtime[i] );
        viewHolderClass.remove.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        } );


    }


    @Override
    public int getItemCount() {
        return images.length;
    }

    public class ViewHolderClass extends RecyclerView.ViewHolder {
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

        public ViewHolderClass(@NonNull View itemView, final ClickListener listener) {
            super( itemView );


            count = itemView.findViewById( R.id.tv_quantity );

            plus = itemView.findViewById( R.id.item_add );
            minus = itemView.findViewById( R.id.item_sub );


           /* name = itemView.findViewById(R.id.item_name);
            productName = itemView.findViewById(R.id.rest_name);
            *//*prod_unit = itemView.findViewById(R.id.tv_unit);
            price = itemView.findViewById(R.id.tv_price);
            quantity = itemView.findViewById(R.id.tv_quantity);*//*
            prod_image = itemView.findViewById(R.id.img_prod);
            prod_image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    context.startActivity(new Intent(context, ProductActivity.class));
                }
            });*/

            plus.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    sum = Integer.parseInt( count.getText().toString() );
                    single_item_price = Integer.parseInt( single_price.getText().toString() );

                    sum = sum + 1;
                    Log.e( "Quantity value2", "" + sum );
                    if (sum > 0) {
                        count.setVisibility( View.VISIBLE );
                        minus.setVisibility( View.VISIBLE );
                        price.setVisibility( View.VISIBLE );
                    }
                    count.setText( String.valueOf( sum ) );

                    price.setText( "\u20B9 " + (single_item_price * sum) );
                    listener.itemClick( view, getAdapterPosition(), sum );
                }
            } );
            minus.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sum = Integer.parseInt( count.getText().toString() );
                    single_item_price = Integer.parseInt( single_price.getText().toString() );

                    if (sum > 0) {
                        sum = sum - 1;
                        if (sum == 0) {
                            count.setVisibility( View.INVISIBLE );
                            minus.setVisibility( View.INVISIBLE );
                            price.setVisibility( View.GONE );
                        } else {
                            price.setVisibility( View.VISIBLE );
                        }
                        count.setText( String.valueOf( sum ) );
                        price.setText( "\u20B9 " + (single_item_price * sum) );
                        listener.itemClick( view, getAdapterPosition(), sum );
                    }
                }

            } );
        }

        public ViewHolderClass(@NonNull View itemView) {
            super( itemView );
            imageView = itemView.findViewById( R.id.tataimg );
            txtview = itemView.findViewById( R.id.tatatitle );
            txtview1 = itemView.findViewById( R.id.price );
            txtview2 = itemView.findViewById( R.id.orderdate );

        }
    }

}