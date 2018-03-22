package com.example.prajakta.orphanage_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class login extends AppCompatActivity {
    EditText editText_email, editText_password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editText_email = (EditText) findViewById(R.id.editText_email);
        editText_password = (EditText) findViewById(R.id.editText_password);
    }

    public void OnLogin(View view) {
        String email = editText_email.getText().toString();
        String password = editText_password.getText().toString();
        String type = "login";
        Backendconnectivity backedconnectivity = new Backendconnectivity(this);
        backedconnectivity.execute(type, email, password);
    }


}
