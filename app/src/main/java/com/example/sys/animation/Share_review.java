package com.example.sys.animation;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Share_review extends Fragment {
    Button share;
    public Share_review() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
View view=inflater.inflate(R.layout.activity_share_review, container, false);
share=view.findViewById( R.id.share);
share.setOnClickListener( new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if (isPermissionGranted()) {
            final String appPackageName = getActivity().getPackageName();
            Intent sendIntent = new Intent();
            sendIntent.setAction( Intent.ACTION_SEND );
            sendIntent.putExtra( Intent.EXTRA_TEXT, "Check out the App at: https://play.google.com/store/apps/details?id=" + appPackageName );
            sendIntent.setType( "text/plain" );
            startActivity( sendIntent );

        }
    }
} );
        return view;



    }
    public boolean isPermissionGranted() {
        if (Build.VERSION.SDK_INT >= 23) {
            if ((ContextCompat.checkSelfPermission( getActivity(),Manifest.permission.SEND_SMS)== PackageManager.PERMISSION_GRANTED)) {
                Log.v("TAG", "Permission is granted");
                return true;
            } else {

                Log.v("TAG", "Permission is revoked");
                ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CALL_PHONE,Manifest.permission.CAMERA,Manifest.permission.SEND_SMS}, 1);
                return false;
            }
        } else { //permission is automatically granted on sdk<23 upon installation
            Log.v("TAG", "below 23");
            return true;
        }
    }

}

