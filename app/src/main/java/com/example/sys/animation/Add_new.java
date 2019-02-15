package com.example.sys.animation;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;

public class Add_new extends Fragment {
    public static final String MyPREFERENCES = "MyPrefs" ;
    Database_class db;
    EditText name,houseno,street,landmark,city,district,state,pincode;
    ArrayList<Map<String, String>> data1;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_add_new, container, false);
        SharedPreferences pref = getActivity().getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        String email = pref.getString("Username", "as");
        data1 = new ArrayList<Map<String, String>>();
        db = new Database_class(getActivity());
        data1 = db.getprofile(email);

        name = view.findViewById(R.id.name);
        houseno = view.findViewById(R.id.houseno);
        street = view.findViewById(R.id.street);
        landmark = view.findViewById(R.id.Landmark);
        city = view.findViewById(R.id.city);
        district = view.findViewById(R.id.district);

        name.setText(data1.get(0).get(Database_class.NAME));
        houseno.setText(data1.get(0).get(Database_class.HOUSE_NO));
        street.setText(data1.get(0).get(Database_class.STREET));
        landmark.setText(data1.get(0).get(Database_class.LANDMARK));
        city.setText(data1.get(0).get(Database_class.CITY));
        district.setText(data1.get(0).get(Database_class.DISTRICT));

        return view;
    }
}
