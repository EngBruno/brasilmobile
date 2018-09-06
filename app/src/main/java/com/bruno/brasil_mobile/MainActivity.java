package com.bruno.brasil_mobile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.StringRequest;
import com.bruno.brasil_mobile.model.State;
import com.bruno.brasil_mobile.ui.activity.CityActivity;
import com.bruno.brasil_mobile.util.Util;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listViewState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        String json = getListState();
        listViewState = (ListView)findViewById(R.id.lista);
        listViewState.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("click",""+position);
                Intent intent = new Intent(MainActivity.this, CityActivity.class);
                startActivity(intent);
            }
        });
    }

    public String getListState(){
        String jsonlistState = "";

        RequestQueue mRequestQueue;
        // Instantiate the cache
        Cache cache = new DiskBasedCache(getCacheDir(), 1024 * 1024); // 1MB cap
        // Set up the network to use HttpURLConnection as the HTTP client.
        Network network = new BasicNetwork(new HurlStack());
        // Instantiate the RequestQueue with the cache and network.
        mRequestQueue = new RequestQueue(cache, network);
        /* Start the queue */
        mRequestQueue.start();


        // Formulate the request and handle the response.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, "http://192.168.77.1:8080/estados",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Do something with the response
                        listViewState.setAdapter(creatAdapter(Util.createListState(response)));
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("response",error.getMessage());
                    }
                });
        // Add the request to the RequestQueue.
        mRequestQueue.add(stringRequest);
        return jsonlistState;
    }


    private ArrayAdapter<?> creatAdapter(List<State> list){
        ArrayAdapter<State> adapterCity = new ArrayAdapter<State>(this,android.R.layout.simple_list_item_1,list);
        return adapterCity;
    }
}
