package com.ansari.b17recyclerview;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MyAdapter myAdapter;
    public static final String url = "https://api.androidhive.info/contacts/";
    ProgressDialog progressDialog;

    List<Movie> movieList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myAdapter = new MyAdapter(movieList);

        recyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
       // recyclerView.setAdapter(myAdapter);
            getDataFromServer();
        //addData();
    }

    private void getDataFromServer() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading Data in background !!!");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {

                    progressDialog.dismiss();
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("contacts");

                    for(int i=0;i<=jsonArray.length();i++){

                        JSONObject myContacts = jsonArray.getJSONObject(i);
                        String tilte = myContacts.getString("name");
                        String genere = myContacts.getString("email");
                        String year = myContacts.getString("gender");

                        Movie movie = new Movie(tilte,genere,year);
                        movieList.add(movie);

                        recyclerView.setAdapter(myAdapter);

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });


        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(stringRequest);

    }



    private void addData() {

        Movie m1 = new Movie("TITLE 1","GENERE 1","2010");
        movieList.add(m1);
        Movie m2 = new Movie("TITLE 2","GENERE 2","2012");
        movieList.add(m2);
        Movie m3 = new Movie("TITLE 3","GENERE 3","2013");
        movieList.add(m3);
        Movie m4 = new Movie("TITLE 4","GENERE 4","2014");
        movieList.add(m4);


    }
}
