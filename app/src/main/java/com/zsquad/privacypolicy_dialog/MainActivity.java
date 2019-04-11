package com.zsquad.privacypolicy_dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.zsquad.privacypolicydialoglibrary.PrivacyPolicyDialog;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PrivacyPolicyDialog dialog=new PrivacyPolicyDialog();
        dialog.setNextActivity(Main2Activity.class);
        dialog.show(getSupportFragmentManager(), "Text");
    }
}
