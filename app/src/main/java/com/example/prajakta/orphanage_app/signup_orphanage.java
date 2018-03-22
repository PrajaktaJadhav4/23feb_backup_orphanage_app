package com.example.prajakta.orphanage_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class signup_orphanage extends AppCompatActivity {
    EditText name , email , password , o_name , o_address;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_orphanage);
        name = (EditText)findViewById(R.id.et_name);
        email = (EditText)findViewById(R.id.et_email);
        password = (EditText)findViewById(R.id.et_password);
        o_name = (EditText)findViewById(R.id.et_orphanage_name);
        o_address = (EditText)findViewById(R.id.et_orphanage_address);
    }

    public void OnSignup(View view){
        String category = "Orphanage";
        String str_name = name.getText().toString();
        String str_email = email.getText().toString();
        String str_password = password.getText().toString();
        String type = "signup";
        String str_o_name = o_name.getText().toString();
        String str_o_address = o_address.getText().toString();
        Backendconnectivity backedconnectivity = new Backendconnectivity(this);
        backedconnectivity.execute(type, str_name, str_email, str_password, category, str_o_name, str_o_address);
    }
}
