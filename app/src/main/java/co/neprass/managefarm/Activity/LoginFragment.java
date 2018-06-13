package co.neprass.managefarm.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import co.neprass.managefarm.R;


public class LoginFragment extends AppCompatActivity {
    View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_login);
        findViewById(R.id.btnLogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginFragment.this.finish();
                Intent refresh = new Intent(LoginFragment.this, MainActivity.class);
                startActivity(refresh);
            }
        });


    }


}
