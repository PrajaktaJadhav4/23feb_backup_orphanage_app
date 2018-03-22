package com.example.prajakta.orphanage_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private static Button button_sign_in , button_sign_up;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        OnClickButtonListner();

    }
    //intent code
    public void OnClickButtonListner(){
        button_sign_in = (Button)findViewById(R.id.button_sign_in);
        button_sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_login = new Intent("com.example.prajakta.orphanage_app.login");
                startActivity(intent_login);
            }
        });

        button_sign_up = (Button)findViewById(R.id.button_sign_up);
        button_sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_sign_up = new Intent("com.example.prajakta.orphanage_app.sign_up");
                startActivity(intent_sign_up);
            }
        });
    }



}
