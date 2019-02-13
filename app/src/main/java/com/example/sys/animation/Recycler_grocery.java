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
   int[] images;


    public Recycler_grocery(Context Grocery, String[] arr, int[] images) {
        context= Grocery;
        this.arr=arr;
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
        viewHolderClass.imageView.setImageResource(images[i]);

    }


    @Override
    public int getItemCount() {
        return arr.length;
    }

    class ViewHolderClass extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;
        public ViewHolderClass(@NonNull View itemView) {
            super( itemView );
            textView=itemView.findViewById(R.id.tv_fruits);
            imageView = itemView.findViewById(R.id.fruits);

        }
    }}