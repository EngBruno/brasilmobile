package com.bruno.brasil_mobile.client;

import android.util.Log;

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

import java.io.File;

public class Client {

    public String getListState(File file){

        final String jsonlistState = "";

        RequestQueue mRequestQueue;
        // Instantiate the cache
        Cache cache = new DiskBasedCache(file, 1024 * 1024); // 1MB cap
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

}
