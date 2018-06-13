package co.neprass.managefarm.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

import co.neprass.managefarm.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
//                if (!TextUtils.isEmpty(ApplicationController.getInstance().token())) {

                    SplashActivity.this.finish();
                    Intent refresh = new Intent(SplashActivity.this, LoginFragment.class);
                    startActivity(refresh);

//                } else {
//                    finish();
//                    Intent intent = new Intent(MainActivity.this, Login.class);
//                    startActivity(intent);
//                }

            }
        };
        Timer opening = new Timer();
        opening.schedule(task, 4000);
    }
}
