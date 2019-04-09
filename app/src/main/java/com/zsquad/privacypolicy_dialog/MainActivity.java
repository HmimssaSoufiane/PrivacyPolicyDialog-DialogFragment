package com.zsquad.privacypolicy_dialog;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnAccep;
        Button btnCanal;
        btnAccep= findViewById(R.id.dialogbtn1);
        btnCanal= findViewById(R.id.dialogbtn2);
        if (restorePrefData()) {
            Intent i = new Intent(getApplicationContext(),Main2Activity.class );
            startActivity(i);
            finish();
        }
        btnAccep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //open main activity
                Intent i = new Intent(getApplicationContext(),Main2Activity.class);
                startActivity(i);
                savePrefsData();
                finish();
            }
        });
        btnCanal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
    private boolean restorePrefData() {

        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPrefs",MODE_PRIVATE);
        Boolean isIntroActivityOpnendBefore = pref.getBoolean("isIntroOpnend",false);
        return  isIntroActivityOpnendBefore;
    }
    private void savePrefsData(){

        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPrefs",MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("isIntroOpnend",true);
        editor.commit();
    }
}
