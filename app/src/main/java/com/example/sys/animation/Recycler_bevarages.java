package com.example.sys.animation;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Recycler_bevarages extends BaseAdapter {
    Context context;
    String[] arr;
    int[] img;
    String[] arr1;

    ListView view;
    public Recycler_bevarages(Context context, String[] arr, int[] img,  String[] arr1)

    {
        this.context = context;
        this.arr = arr;
        this.img = img;
        this.arr1 = arr1;


    }

    @Override
    public int getCount() {
        return img.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View customView, view;
        view = LayoutInflater.from(context).inflate(R.layout.activity_recycler_bevarages, parent, false);
        ImageView image = view.findViewById(R.id.img);
        TextView ping=view.findViewById(R.id.tata);
        TextView ing=view.findViewById(R.id.rupees);



        image.setImageResource(img[position]);
        ping.setText(arr[position]);
        ing.setText(arr1[position]);

        customView = view;

        return customView;
    }
}
