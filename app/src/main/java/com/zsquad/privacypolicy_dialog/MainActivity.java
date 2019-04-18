package com.zsquad.privacypolicy_dialog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.zsquad.privacypolicydialoglibrary.PrivacyPolicyDialog;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                    while (dialog.isDismiss == false) {
                        this.wait(3000);
                    }
                } catch (Exception e){}
                finally {
                    System.out.println("Fin demon");
                    startActivity(new Intent(MainActivity.this, Main2Activity.class));
                }
            }

        }, "Demon");

        daemonThread.start();
        //

    }
}
