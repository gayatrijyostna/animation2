package com.example.sys.animation;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;

public class Grocery extends Fragment {
        RecyclerView recyclerView;
        int[] images = {R.drawable.fruits, R.drawable.bread, R.drawable.bevarages2,R.drawable.personal,R.drawable.fruits,R.drawable.bread,R.drawable.bevarages2,R.drawable.personal};
        String[] arr={"Fruits and vegetables","Bread,Dairy and Eggs","Bevarages","Personal Care","Fruits and vegetables","Bread,Dairy and Eggs","Bevarages","Personal Care"};

        ArrayAdapter<String> adapter;
        Recycler_grocery recycler;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate( R.layout.activity_main, container, false );
        RecyclerView recyclerView1 = view.findViewById( R.id.recycler3 );
        recyclerView1.setLayoutManager( new GridLayoutManager( getActivity(),2 ) );
            Recycler_grocery recyclerAdapter = new Recycler_grocery( getActivity(),arr,images);
            recyclerView1.setAdapter( recyclerAdapter );
        getActivity().getWindow().setSoftInputMode( WindowManager.
                LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        getActivity().setTitle( "GROCERY" );
return view;
        }

}
