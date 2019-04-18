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

        Toast.makeText(MainActivity.this, "start", Toast.LENGTH_SHORT).show();

        Bundle args = new Bundle();
        args.putString("storeName", "ArchaSoft ");
        args.putString("PrivacyURL", "https://github.com/HmimssaSoufiane/PrivacyPolicyDialog");
        final PrivacyPolicyDialog dialog = new PrivacyPolicyDialog();
        dialog.setArguments(args);
        dialog.show(getSupportFragmentManager(), "Text");

        Thread daemonThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (!dialog.isDismiss) {
                        Log.i("thread", "while");
                        Thread.sleep(4000);
                    }
                } catch (Exception e) {
                    Log.i("thread", "Exception"+e.getMessage());


                } finally {
                    startActivity(new Intent(MainActivity.this,Main2Activity.class ));
                    Log.i("thread", "Fin");

                    finish();
                }
            }

        }, "Demon");

        daemonThread.start();


    }
}
