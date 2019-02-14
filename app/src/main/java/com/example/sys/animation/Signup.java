package com.example.sys.animation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Map;

public class Signup extends AppCompatActivity {
    private Database_class dataBaseClass;

    public static final String EMAIL_PATTERN = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    public static final String NAME_PATTERN = "[a-zA-Z., ]+([ '-][a-zA-Z., ]+)*";
    ArrayList <Map <String, String>> data1=new ArrayList <>(  );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_signup );
        dataBaseClass = new Database_class(Signup.this);
        getWindow().setSoftInputMode( WindowManager.
                LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        final EditText email = findViewById(R.id.mail);
        final EditText password = findViewById(R.id.pwd);
        Button login = findViewById(R.id.signup);
        login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String email_str = email.getText().toString().trim();
                String password_str = password.getText().toString().trim();
                boolean value = true;
                if (!email_str.equals("") && !password_str.equals(""))
                {
                    if (!email_str.matches(EMAIL_PATTERN) ) {
                        value = false;
                        email.setError("Email invalid");
                    }
                    if(!password_str.matches(NAME_PATTERN ) || (password_str.length()<3) || (password_str.length()>30) ) {
                        value = false;
                        password.setError("password invalid");
                    }
                    if( value == true) {
                        data1=dataBaseClass.getRetrive(email_str,password_str);
                        if(data1.isEmpty()) {
                            dataBaseClass.insertValues(email_str, password_str);
                            Intent i = new Intent( Signup.this, Navigation_drawer.class );
                            startActivity( i );
                            Toast.makeText( Signup.this, "successfully saved", Toast.LENGTH_SHORT ).show();

                        }
                        else {
                            Toast.makeText( Signup.this, "email id already exists", Toast.LENGTH_SHORT ).show();

                        }
                    }
                } else {
                    Toast.makeText(Signup.this, "Plz fill the details", Toast.LENGTH_SHORT).show();

                }
                    }

});
    }}