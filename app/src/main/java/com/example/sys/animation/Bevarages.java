package com.example.sys.animation;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class Bevarages extends AppCompatActivity {
    RatingBar r;
    ListView view;
    ImageView filter;
    String[] arr = {"Tata salt 1kg", "Fortune oil 1lt", "Vim dish bar", "Maggie 2mins masal"};
    String[] arr1 = {"Rs 18", "Rs 19", "Rs 47", "Rs 47"};
    int[] img = {R.drawable.salt, R.drawable.fortune, R.drawable.vim, R.drawable.maggi};
    Recycler_bevarages customAdapter;
    PopupWindow mypopupWindow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bevarages);
        view = findViewById(R.id.list);
        customAdapter = new Recycler_bevarages(this, arr, img, arr1);
        view.setAdapter(customAdapter);
        filter=findViewById( R.id.filter );
        filter.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = (LayoutInflater)
                        getApplicationContext().getSystemService( Context.LAYOUT_INFLATER_SERVICE);
                view = (ListView) inflater.inflate(R.layout.popup_menu, null);
                mypopupWindow = new PopupWindow(view,300, RelativeLayout.LayoutParams.WRAP_CONTENT, true);
            }
        } );

    }

    public void addListenerOnButtonClick() {
        r = (RatingBar) findViewById(R.id.ratingBar);
        r.getOnRatingBarChangeListener();
        String rating = String.valueOf(r.getRating());
        Toast.makeText(getApplicationContext(), rating, Toast.LENGTH_LONG).show();
    }

}
