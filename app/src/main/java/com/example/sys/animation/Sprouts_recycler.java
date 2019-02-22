package com.example.sys.animation;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class Sprouts_recycler extends RecyclerView.Adapter<Sprouts_recycler.MyViewHolder> {


    Context context;
    String[] name;
    String[] rupees;
    int[] img;

    private ClickListener clickListener;
    public Sprouts_recycler(Context Sprouts_recycler, String[] name, String[] rupees, int[] img, ClickListener clickListener) {
        context= Sprouts_recycler;
        this.clickListener= clickListener;
        this.name=name;
        this.rupees=rupees;
        this.img=img;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.activity_sprouts_recycler,viewGroup,false );
//        Recycler_bevarages.ViewHolderClass viewHolderClass=new Recycler_bevarages.ViewHolderClass(view);
        return new MyViewHolder(view, clickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull Sprouts_recycler.MyViewHolder myViewHolder, final int i) {
        myViewHolder.textView.setText( name[i] );
        myViewHolder.textview2.setText( rupees[i] );
        myViewHolder.imageView.setImageResource( img[i] );
        myViewHolder.imageView.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,Share_review.class);
                intent.putExtra( "position",i );
                context.startActivity( intent );


            }
        } );

    }



    @Override
    public int getItemCount() {
        return name.length;
    }


    public  class MyViewHolder extends RecyclerView.ViewHolder {
        TextView quantity;
        TextView  plus, minus;
        int sum;

        TextView textView;
        TextView textview2;
        ImageView imageView;
        public MyViewHolder(@NonNull View itemView,final ClickListener listener) {
            super( itemView );
            textView=itemView.findViewById(R.id.name);
            textview2=itemView.findViewById(R.id.rupees);
            imageView = itemView.findViewById(R.id.img);
            quantity = itemView.findViewById(R.id.tv_quantity);
            plus = itemView.findViewById(R.id.item_add);
            minus = itemView.findViewById(R.id.item_sub);

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
                    Log.e( "sum",String.valueOf(sum) );
                    Log.e("lol",Integer.toString(getAdapterPosition()));
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
