package com.example.prajakta.orphanage_app;

import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.support.v7.widget.SearchView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import android.widget.Filter;
import android.widget.Filterable;



public class non_orphanage_page extends AppCompatActivity {
    SearchView searchView;
    private static final String URL_DATA = "http://192.168.1.5/fetch.php";

    private RecyclerView recyclerView;
    //private RecyclerView.Adapter adapter;
    private ArrayList<orphanage_data_for_non_orphanages> listItems;
    private Adapter_for_Orphanage_data_for_non_orphanage_page adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_non_orphanage_page);



        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listItems = new ArrayList<>();
        loadProducts();

    }

    //connecting to database to fetch data for recycler view
    private void loadProducts(){
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
                    adapter=new Adapter_for_Orphanage_data_for_non_orphanage_page(listItems,non_orphanage_page.this);
                    recyclerView.setAdapter(adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(non_orphanage_page.this,error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        Volley.newRequestQueue(this).add(stringRequest);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.searchfile,menu);
        MenuItem search = menu.findItem(R.id.search);
        //SearchView searchView = (SearchView)MenuItemCompat.getActionView(search);
        SearchView searchView = (SearchView) search.getActionView();
        search(searchView);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        return super.onOptionsItemSelected(item);
    }


    private void search(SearchView searchView) {
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);

                return true;
            }
        });
    }

}
