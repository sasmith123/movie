package com.example.myapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

public class mainclassformainrecyclerview extends AppCompatActivity {
    private static final String URL_DATA1="https://api.themoviedb.org/3/movie/now_playing?api_key=4dc0b4988b87a649ec57904fdaed2a9d&language=en-US&page=1";
    RecyclerView recyclerView1,itemRecycler;
    RecyclerView.Adapter apter,adapter;
   public List<category> categoryList;
    public List<layout2> listitems2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainrecyclerviewpage);
        itemRecycler=findViewById(R.id.item_recycler);
        recyclerView1=findViewById(R.id.recyclerview1);
        recyclerView1.setLayoutManager(new LinearLayoutManager(this));
        recyclerView1.setHasFixedSize(true);
         listitems2=new ArrayList<>();
        loadRecylerViewData();

        categoryList= new ArrayList<>();
      categoryList.add(new category("hollywood",listitems2));
        categoryList.add(new category("dubbed",listitems2));
        categoryList.add(new category("rated",listitems2));
      setMainCategoryRecycler(categoryList);
    }

    private void loadRecylerViewData() {
        ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Loading Data");
        progressDialog.show();
        StringRequest stringRequest=new StringRequest(Request.Method.GET,
                URL_DATA1, new Response.Listener<String>() {
            @Override
            public void onResponse(String respons) {
                progressDialog.dismiss();
                try {
                    JSONObject jsonObject=new JSONObject(respons);
                    JSONArray array=jsonObject.getJSONArray("results");
                    for(int i=0;i<array.length();i++){
                        JSONObject object=array.getJSONObject(i);
                        layout2 item =new layout2(object.getString("original_title"),
                                object.getString("vote_average"),
                                object.getString("poster_path"));
                        listitems2.add(item);
                    }
                    adapter = new adapter(listitems2,getApplicationContext());
                    itemRecycler.setAdapter(adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }


    private void setMainCategoryRecycler(List<category> categoryList) {
        recyclerView1 = findViewById(R.id.recyclerview1);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView1.setLayoutManager(layoutManager);
        apter = new MainrecyclerviewAdapter(this, categoryList);
        recyclerView1.setAdapter(apter);
    }
}
