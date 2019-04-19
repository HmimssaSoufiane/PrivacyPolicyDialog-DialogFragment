package com.zsquad.privacypolicy_dialog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.zsquad.privacypolicydialoglibrary.PrivacyPolicyDialog;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Bundle args = new Bundle();
        args.putString("storeName", "ArchaSoft ");
        args.putString("PrivacyURL", "https://github.com/HmimssaSoufiane/PrivacyPolicyDialog");
        PrivacyPolicyDialog dialog = new PrivacyPolicyDialog();
        dialog.setArguments(args);
        dialog.show(getSupportFragmentManager(), "Text");
        final Intent goNextActivity = new Intent(this, Main2Activity.class);

        Thread daemonThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (!PrivacyPolicyDialog.isDismiss) {
                        Log.i("thread", "while");
                        Thread.sleep(1000);
                    }
                } catch (Exception e) {
                    Log.i("thread", "Exception" + e.getMessage());


                } finally {
                    startActivity(goNextActivity);
                    Log.i("thread", "Fin");
                    finish();
                }
            }

        }, "Demon");

        daemonThread.start();


    }
}
