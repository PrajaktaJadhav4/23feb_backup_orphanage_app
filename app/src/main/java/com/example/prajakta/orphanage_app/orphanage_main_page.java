package com.example.prajakta.orphanage_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class orphanage_main_page extends AppCompatActivity implements AsyncResponse{
Backendconnectivity backendconnectivity = new Backendconnectivity(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        backendconnectivity.getdata = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orphanage_main_page);

        String name = getIntent().getStringExtra("o_name");
        TextView tv = (TextView)findViewById(R.id.textViewdemo);
        tv.setText(name);
        String type = "single_orphanage_page";
        backendconnectivity.execute(type ,name);


    }



    @Override
    public void processFinish(String output) {
        Toast.makeText(this,output,Toast.LENGTH_SHORT).show();

    }
}
