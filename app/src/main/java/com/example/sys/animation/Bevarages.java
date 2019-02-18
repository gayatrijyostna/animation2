package com.example.sys.animation;

import android.app.Activity;
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

public class Bevarages extends AppCompatActivity {
    RatingBar r;
    OnFragmentSendVal vSendVal;
    private RatingBar ratingBar;
    RecyclerView recyclerView;
    ImageView filter;
    String[] arr = {"Tata salt 1kg", "Fortune oil 1lt", "Vim dish bar", "Maggie 2mins masal"};
    String[] arr1 = {"Rs 18", "Rs 19", "Rs 47", "Rs 47"};
    int[] img = {R.drawable.salt, R.drawable.fortune, R.drawable.vim, R.drawable.maggi};
    ArrayAdapter<String> adapter;
    Recycler_bevarages recycler;

    public interface OnFragmentSendVal{
        public void onSentVal(float value);
    }

    public Bevarages() {
        // Required empty public constructor
    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try{
            vSendVal = (OnFragmentSendVal)activity;
        }catch (ClassCastException e){
            throw new ClassCastException(activity.toString() + " must implement OnFragmentSendVal");
        }
    }


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_bevarages, container, false);
        RecyclerView recyclerView1 = view.findViewById(R.id.recycle);

        recyclerView1.setLayoutManager(new GridLayoutManager(Bevarages.this, 2));
        Recycler_bevarages recyclerAdapter = new Recycler_bevarages(Bevarages.this, arr, arr1, img);
        recyclerView1.setAdapter(recyclerAdapter);
      getWindow().setSoftInputMode(WindowManager.
                LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
 setTitle("GROCERY");
        addListenerOnRatingBar(view);
        return view;
    }

    private void addListenerOnRatingBar(View view) {
        ratingBar = (RatingBar) view.findViewById(R.id.ratingBar);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float rating,
                                        boolean fromUser) {



                float val = rating;
                vSendVal.onSentVal(val);
                //txtRatingValue.setText(String.valueOf(rating));

            }
        });
    }

    }
