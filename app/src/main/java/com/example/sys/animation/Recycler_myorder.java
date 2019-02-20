package com.example.sys.animation;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class Recycler_myorder extends RecyclerView.Adapter<Recycler_myorder.ViewHolderClass> {
    Context context;
    int[] images;
    String[] imgname;
    String[] price;
    String[] orderedtime;
    String[] review,reorder;


    public Recycler_myorder(Context My_order, int[] images, String[] imgname, String[] price, String[] orderedtime, String[] review, String[] reorder, ClickListener clickListener) {
        context = My_order;
        this.images = images;
        this.imgname=imgname;
        this.price=price;
        this.orderedtime=orderedtime;
        this.review=review;
        this.reorder=reorder;

    }

    @NonNull
    @Override
    public ViewHolderClass onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from( context ).inflate( R.layout.activity_recycler_myorder, viewGroup, false );
        ViewHolderClass viewHolderClass = new Recycler_myorder.ViewHolderClass( view );
        return viewHolderClass;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderClass viewHolderClass, int i) {
        viewHolderClass.imageView.setImageResource( images[i] );
        viewHolderClass.txtview.setText( imgname[i]);
        viewHolderClass.txtview1.setText( price[i]);
        viewHolderClass.txtview2.setText( orderedtime[i]);
        viewHolderClass.review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(context,Review.class);
                context.startActivity( i );
            }
        });
        viewHolderClass.reorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,Grocery.class);
                context.startActivity(intent);
            }
        });



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
        TextView review;
        TextView reorder;

        public ViewHolderClass(@NonNull View itemView) {
            super( itemView );
            imageView = itemView.findViewById( R.id.tataimg );
            txtview=itemView.findViewById(R.id.tatatitle);
            txtview1=itemView.findViewById( R.id.price );
            txtview2=itemView.findViewById( R.id.orderdate );
            review=itemView.findViewById( R.id.Review );
            reorder=itemView.findViewById( R.id.Reorder );




        }
    }
}
