package com.example.prajakta.orphanage_app;


import android.app.AlertDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by PRAJAKTA on 12-03-2018.
 */import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class tab_orphanage_pge extends Fragment {


    EditText o_name, o_address, o_mobile_number, o_email, o_description, o_requirements;

    Button bt_update;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.tab_oraphanage_side, container, false);


        o_name = (EditText)rootView.findViewById(R.id.et_o_name);
        o_address = (EditText)rootView.findViewById(R.id.et_o_address);
        o_mobile_number = (EditText)rootView.findViewById(R.id.et_o_mobile_no);
        o_email = (EditText)rootView.findViewById(R.id.et_o_email);
        o_requirements = (EditText)rootView.findViewById(R.id.et_clothes_quantity);
        o_description = (EditText)rootView.findViewById(R.id.et_description);
        bt_update = (Button)rootView.findViewById(R.id.bt_update);

        bt_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              String type = "update";
                 String str_name = o_name.getText().toString();
                 String str_address = o_address.getText().toString();
                 String str_mobile = o_mobile_number.getText().toString();
                 String str_email = o_email.getText().toString();
                 String str_requirements = o_requirements.getText().toString();
                 String str_description = o_description.getText().toString();

                Backendconnectivity backedconnectivity = new Backendconnectivity(getContext());
                backedconnectivity.execute(type, str_name, str_email, str_address, str_mobile, str_requirements, str_description);
Toast.makeText(getContext(),"hoioioioio",Toast.LENGTH_SHORT).show();
            }
        });




        /*bt_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String str_name = o_name.getText().toString();
                final String str_address = o_address.getText().toString();
                final String str_mobile = o_mobile_number.getText().toString();
                final String str_email = o_email.getText().toString();
                final String str_requirements = o_requirements.getText().toString();
                final String str_description = o_description.getText().toString();

                String update_url = "http://192.168.1.7/update.php";



                StringRequest stringRequest = new StringRequest(Request.Method.POST, update_url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                    }
                }
                        , new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String,String> param = new HashMap<String, String>();
                        param.put("name",str_name);
                        param.put("address",str_address);
                        param.put("email",str_email);
                        param.put("mobile_no",str_mobile);
                        param.put("requirements",str_requirements);
                        param.put("description",str_description);
                        return param;
                    }

                };

                Volley.newRequestQueue(rootView.getContext().getApplicationContext()).add(stringRequest);
            }
        });*/


        return rootView;
    }


}
