package com.valentishealth.app.presshub.activities;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.valentishealth.app.presshub.R;
import com.valentishealth.app.presshub.adapters.RecyclerAdapter;
import com.valentishealth.app.presshub.model.Modelist;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    private final String BASE_URL = "https://gist.githubusercontent.com/aws1994/f583d54e5af8e56173492d3f60dd5ebf/raw/c7796ba51d5a0d37fc756cf0fd14e54434c547bc/anime.json";
    private JsonArrayRequest request;
    private  RequestQueue requestQueue;
    private List<Modelist> modelists;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        modelists = new ArrayList<>();


     recyclerView = findViewById(R.id.recyclerView);
     jsonrequest();

        RecyclerAdapter myadapter = new RecyclerAdapter(this, modelists);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(myadapter);



    }

    private void jsonrequest() {

        request = new JsonArrayRequest(BASE_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

         JSONObject jsonObject = null;
         for (int x = 0; x <response.length(); x++) {

             try {
                 jsonObject = response.getJSONObject(x);

                 Modelist datamodel = new Modelist();

                 datamodel.setName(jsonObject.getString("name"));
                 datamodel.setDescription(jsonObject.getString("description"));
                 datamodel.setRating(jsonObject.getString("Rating"));
                 datamodel.setEpisode(jsonObject.getInt("episode"));
                 datamodel.setCategories(jsonObject.getString("categorie"));
                 datamodel.setStudio(jsonObject.getString("studio"));
                 datamodel.setImg(jsonObject.getString("img"));
                 modelists.add(datamodel);

             } catch (JSONException e) {
                 e.printStackTrace();
             }

         }

          setuprecyclerview(modelists);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }

    private void setuprecyclerview(List<Modelist> modelists) {


    }


}