package com.example.sys.animation;

import android.content.Context;
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
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class Bevarages extends Fragment {
    RatingBar r;
    RecyclerView recyclerView;
    ImageView filter;
    String[] arr = {"Tata salt 1kg", "Fortune oil 1lt", "Vim dish bar", "Maggie 2mins masal"};
    String[] arr1 = {"Rs 18", "Rs 19", "Rs 47", "Rs 47"};
    int[] img = {R.drawable.salt, R.drawable.fortune, R.drawable.vim, R.drawable.maggi};
    ArrayAdapter<String> adapter;
    Recycler_bevarages recycler;


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_bevarages, container, false);
        RecyclerView recyclerView1 = view.findViewById(R.id.recycle);
//            addListenerOnRatingBar();
        recyclerView1.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        Recycler_bevarages recyclerAdapter = new Recycler_bevarages(getActivity(), arr, arr1, img);
        recyclerView1.setAdapter(recyclerAdapter);
        getActivity().getWindow().setSoftInputMode(WindowManager.
                LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        getActivity().setTitle("GROCERY");
        return view;
    }

//        public void addListenerOnButtonClick () {
//            r = (RatingBar) findViewById(R.id.ratingBar);
//            r.getOnRatingBarChangeListener();
//            String rating = String.valueOf(r.getRating());
//            Toast.makeText(getApplicationContext(), rating, Toast.LENGTH_LONG).show();
//        }

    }
