package com.example.zsquad.privacypolicydialoglibrary;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static android.content.Context.MODE_PRIVATE;

public class PrivacyPolicyDialog extends DialogFragment {
    Button btnAccept;
    TextView textViewBrand;
    TextView textViewPrivacyPolicy;
    SharedPreferences pref;
    DialogFragment dialogFragment;

    public PrivacyPolicyDialog() {
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog, container);

        //Dialog style
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        //
        btnAccept = view.findViewById(R.id.dialogbtn1);
        textViewBrand = view.findViewById(R.id.textViewBrand);
        textViewPrivacyPolicy = view.findViewById(R.id.textViewPrivacyPolicy);
        dialogFragment = this;

        //get store name and privacy url
        final Bundle args = getArguments();
        textViewBrand.setText(args.getString("storeName"));

        //SharedPreferences to store dialog show state
        pref = getActivity().getSharedPreferences("myPrefs", MODE_PRIVATE);

        //check dialog state
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

        textViewPrivacyPolicy.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent InfoIntent;
                try {
                    InfoIntent = new Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse(args.getString("PrivacyURL")));
                    startActivity(InfoIntent);

                } catch (ActivityNotFoundException ignored) {

                }
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
