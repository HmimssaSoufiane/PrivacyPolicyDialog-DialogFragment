package com.example.zsquad.privacypolicydialoglibrary;

import android.app.Activity;
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
    Class <? extends Activity> splash;

    public PrivacyPolicyDialog() {
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog, container);


        btnAccept = view.findViewById(R.id.dialogbtn1);
        btnIgnore = view.findViewById(R.id.dialogbtn2);
        pref = getActivity().getSharedPreferences("myPrefs", MODE_PRIVATE);


        if (restorePrefData()) {
            Intent i = new Intent(getActivity(), splash);
            startActivity(i);
            ((Activity) getActivity()).finish();
        }
        btnAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), splash);
                startActivity(i);
                savePrefsData();
                ((Activity) getActivity()).finish();
                Toast.makeText(getActivity(), "Accepted", Toast.LENGTH_SHORT).show();


            }
        });
        btnIgnore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Not Accepted", Toast.LENGTH_SHORT).show();
                ((Activity) getActivity()).finish();
            }
        });
        return view;
    }

    public void setNextActivity(Class yourSplash) {
        this.splash = yourSplash;
    }

    private boolean restorePrefData() {

        return pref.getBoolean("isIntroOpnend", false);
    }

    private void savePrefsData() {


        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("isIntroOpnend", true);
        editor.apply();
    }
}
