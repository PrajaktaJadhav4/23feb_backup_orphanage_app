package com.example.prajakta.orphanage_app;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by PRAJAKTA on 12-03-2018.
 */
import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class tab_nonorphanage_page extends Fragment {
   /* private static final String URL_DATA = "http://192.168.1.7/fetch.php";
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<orphanage_data_for_non_orphanages> listItems;*/
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab_nonorphanage_side, container, false);
        //recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerview);
        //recyclerView.setHasFixedSize(true);
        //recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        //listItems = new ArrayList<>();
        //loadProducts();




        return rootView;
    }

    //connecting to database to fetch data for recycler view
   /* private void loadProducts(){
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_DATA, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray data = new JSONArray(response);

                    for (int i = 0; i<data.length(); i++){
                        JSONObject datao = data.getJSONObject(i);

                        String orphanage_name = datao.getString("orphanage_name");
                        String orphanage_address = datao.getString("orphanage_address");

                        orphanage_data_for_non_orphanages get_o_info = new orphanage_data_for_non_orphanages(orphanage_name,orphanage_address);
                        listItems.add(get_o_info);
                    }
                    adapter = new Adapter_for_tab_nonorphanage(listItems,getActivity().getApplicationContext());
                    recyclerView.setAdapter(adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(),error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        Volley.newRequestQueue(getContext()).add(stringRequest);
    }*/
}
