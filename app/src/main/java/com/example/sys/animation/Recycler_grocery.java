package com.example.sys.animation;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Recycler_grocery extends RecyclerView.Adapter<Recycler_grocery.ViewHolderClass> {

    Context context;
    String[] arr;
    String[] arr1;
    int[] images;


    public Recycler_grocery(Grocery mainActivity, String[] arr, String[] arr1, int[] images) {
        context= mainActivity;
        this.arr=arr;
        this.arr1=arr1;
        this.images=images;
    }


    @NonNull
    @Override
    public ViewHolderClass onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.recycler_fruits,viewGroup,false );
        ViewHolderClass viewHolderClass=new ViewHolderClass(view);
        return viewHolderClass;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderClass viewHolderClass, int i) {
        viewHolderClass.textView.setText( arr[i] );
        viewHolderClass.textView1.setText( arr1[i] );
        viewHolderClass.imageView.setImageResource( images[i] );

    }


    @Override
    public int getItemCount() {
        return arr.length;
    }

    class ViewHolderClass extends RecyclerView.ViewHolder {
        TextView textView;
        TextView textView1;
        ImageView imageView;
        public ViewHolderClass(@NonNull View itemView) {
            super( itemView );

            textView=itemView.findViewById(R.id.name);
            textView1=itemView.findViewById(R.id.nme);
            imageView = itemView.findViewById(R.id.img);

        }
    }