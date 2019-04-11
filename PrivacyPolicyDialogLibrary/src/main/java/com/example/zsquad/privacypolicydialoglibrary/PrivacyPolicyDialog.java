package com.example.zsquad.privacypolicydialoglibrary;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import static android.content.Context.MODE_PRIVATE;

public class PrivacyPolicyDialog extends DialogFragment {
    Button btnAccept;
    Button btnIgnore;
    SharedPreferences pref;
    Context context;
    Class<? extends Activity> splash;

    public PrivacyPolicyDialog(){}

//    public PrivacyPolicyDialog(Context context,Class yourSplashActivity ) {
//        this.context=context;
//        this.splash=yourSplashActivity;
//
//    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog, container);


        btnAccept = view.findViewById(R.id.dialogbtn1);
        btnIgnore = view.findViewById(R.id.dialogbtn2);
        //SharedPreferences pref = context.getSharedPreferences("myPrefs", MODE_PRIVATE);


//        if (restorePrefData()) {
//            Intent i = new Intent(context,splash );
//            startActivity(i);
//            ((Activity) context).finish();
//        }
        btnAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent( context,splash );
                startActivity(i);
                //savePrefsData();
                //((Activity) context).finish();

            }
        });
        btnIgnore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Not Accepted", Toast.LENGTH_SHORT).show();
               // ((Activity) context).finish();
            }
        });
        return view;
    }


//    private boolean restorePrefData() {
//
//        return pref.getBoolean("isIntroOpnend", false);
//    }
//
//    private void savePrefsData() {
//
//
//        SharedPreferences.Editor editor = pref.edit();
//        editor.putBoolean("isIntroOpnend", true);
//        editor.apply();
//    }
}
