package com.example.sys.animation;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class Checkout extends Fragment {
    RecyclerView recyclerView;
    int[] images = {R.drawable.salt, R.drawable.oil, R.drawable.vim};
    String[] imgname={"Tata Salt,1kg","Fortune Oil,1kg","Vim Bar"};
    String[] price={"Price:Rs.18","Price:Rs.52","Price:Rs.20"};
    String[] orderedtime={"Ordered on 04-oct-2017","Ordered on 04-oct-2017","Ordered on 04-oct-2017"};
    String[] review,reorder;

    ArrayAdapter<String> adapter;
    Recycler_myorder recycler;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate( R.layout.activity_checkout, container, false );
        RecyclerView recyclerView1 = view.findViewById( R.id.recycler3 );
        recyclerView1.setLayoutManager( new GridLayoutManager( getActivity(),2 ) );
        Recycler_myorder recyclerAdapter = new Recycler_myorder( getActivity(),images,imgname,price,orderedtime,review,reorder );
        recyclerView1.setAdapter( recyclerAdapter );



        return view;

    }
}
