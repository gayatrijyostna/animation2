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
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Recycler_bevarages extends RecyclerView.Adapter<Recycler_bevarages.ViewHolderClass> {

    Context context;
    String[] arr;
    String[] arr1;
    int[] img;

   private ClickListener clickListener;
    public Recycler_bevarages(Context Grocery, String[] arr1, String[] arr, int[] img,ClickListener clickListener) {
        context= Grocery;
        this.clickListener=clickListener;
        this.arr=arr;
        this.arr1=arr1;
        this.img=img;
    }
    @NonNull
    @Override
    public Recycler_bevarages.ViewHolderClass onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.activity_recycler_bevarages,viewGroup,false );
        Recycler_bevarages.ViewHolderClass viewHolderClass=new Recycler_bevarages.ViewHolderClass(view);
        return viewHolderClass;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderClass viewHolderClass, final int i) {
        viewHolderClass.textView.setText( arr[i] );
        viewHolderClass.textview2.setText( arr1[i] );
        viewHolderClass.imageView.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (arr[i]=="Fruits and vegetables")
                {
                    Intent i=new Intent(context,Home_fragment.class);

                    context.startActivity( i );

                }

            }
        } );

    }


    @Override
    public int getItemCount() {
        return arr.length;
    }


    public  class ViewHolderClass extends RecyclerView.ViewHolder {
        TextView  quantity;
        TextView  plus, minus;
        int sum;

        TextView textView;
        TextView textview2;
        ImageView imageView;
        public ViewHolderClass(@NonNull View itemView,final ClickListener listener) {
            super( itemView );
            textView=itemView.findViewById(R.id.tata);
            textview2=itemView.findViewById(R.id.rupees);
            imageView = itemView.findViewById(R.id.fruits);
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