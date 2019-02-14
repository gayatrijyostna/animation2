package com.example.sys.animation;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Map;

public class Adminpage  extends AppCompatActivity {
    ArrayList<Map<String, String>> data;
    Database_class db;
    EditText email;
    EditText password;
    String username, pswd;
    boolean value=true;
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Username="Username";
    public static final String Password="pswd";
    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_adminpage );
        email = findViewById(R.id.email);
        password = findViewById(R.id.pswd);

        Button login = findViewById(R.id.login);

        SharedPreferences pref = this.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        final String name = pref.getString(Username, "");
        final String password1 = pref.getString(Password, "");
        if (!name.equals( "" )&& !password1.equals( "" )) {
            Intent i = new Intent( Adminpage.this, Navigation_drawer.class );
            startActivity(i);
        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = email.getText().toString().trim();
                pswd = password.getText().toString().trim();
                if (!username.equals("") && !pswd.equals("")) {

                    if (!username.matches(Signup.EMAIL_PATTERN) ) {
                        value = false;
                        email.setError("username invalid");
                    }
                    if (!pswd.matches(Signup.NAME_PATTERN) || !(pswd.length()>3) || !(pswd.length()<8) ) {
                        value = false;
                        email.setError("password invalid");
                    }
                    if(value==true)
                    {
                        data = new ArrayList<Map<String, String>>();
                        db = new Database_class(getApplicationContext());
                        data = db.getRetrive(username, pswd);
                        if (!data.isEmpty()) {
                            Intent i = new Intent(Adminpage.this, Navigation_drawer.class);

                                sharedpreferences = getSharedPreferences( MyPREFERENCES, Context.MODE_PRIVATE );
                                SharedPreferences.Editor editor = sharedpreferences.edit();
                                editor.putString( Username, username );
                                editor.commit();

                            startActivity(i);
                        } else {
                            Toast.makeText(Adminpage.this, "invalid username and password", Toast.LENGTH_SHORT).show();
                        } }
                } else {
                    Toast.makeText(Adminpage.this, "enter details", Toast.LENGTH_SHORT).show();
                }

            }
        });


        TextView signuphere = findViewById(R.id.signup_here);
        signuphere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Adminpage.this, Signup.class);
                startActivity(i);
            }
        });

    }
}
