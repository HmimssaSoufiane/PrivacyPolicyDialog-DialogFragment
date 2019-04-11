package com.example.zsquad.privacypolicydialoglibrary;

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
    DialogFragment dialogFragment;
    public PrivacyPolicyDialog() {
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog, container);


        btnAccept = view.findViewById(R.id.dialogbtn1);
        btnIgnore = view.findViewById(R.id.dialogbtn2);
        pref = getActivity().getSharedPreferences("myPrefs", MODE_PRIVATE);
        dialogFragment=this;


        if (restorePrefData()) {
            dialogFragment.dismiss();
        }
        btnAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                savePrefsData();
                Toast.makeText(getActivity(), "Accepted", Toast.LENGTH_SHORT).show();
                dialogFragment.dismiss();
            }
        });
        btnIgnore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Not Accepted", Toast.LENGTH_SHORT).show();
                (getActivity()).finish();
            }
        });
        return view;
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
