package com.example.prajakta.orphanage_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class signup_non_orphanage extends AppCompatActivity {
    EditText name , email , password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_non_orphanage);
        name = (EditText)findViewById(R.id.et_name);
        email = (EditText)findViewById(R.id.et_email);
        password = (EditText)findViewById(R.id.et_password);
    }

    public void OnSignup(View view){
            String category = "Non_Orphanage";
            String str_name = name.getText().toString();
            String str_email = email.getText().toString();
            String str_password = password.getText().toString();
            String type = "signup";
            String o_name = "";
            String o_address = "";
            Backendconnectivity backedconnectivity = new Backendconnectivity(this);
            backedconnectivity.execute(type, str_name, str_email, str_password, category, o_name, o_address);
    }
}
