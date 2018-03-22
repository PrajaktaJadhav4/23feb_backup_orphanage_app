package com.example.prajakta.orphanage_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class sign_up extends AppCompatActivity {
    private static Button button_non_orphanage, button_orphanage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        OnClickButtonListner();
    }

    public void OnClickButtonListner() {
        button_non_orphanage = (Button) findViewById(R.id.button_non_orphanage);
        button_orphanage = (Button) findViewById(R.id.button_orphanage);
        button_non_orphanage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_non_orphanage_signup = new Intent("com.example.prajakta.orphanage_app.signup_non_orphanage");
                startActivity(intent_non_orphanage_signup);
            }
        });

        button_orphanage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_orphanage_signup = new Intent("com.example.prajakta.orphanage_app.signup_orphanage");
                startActivity(intent_orphanage_signup);
            }
        });


    }
}