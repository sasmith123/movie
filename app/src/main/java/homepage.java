import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapplication.R;
import com.example.myapplication.RecyclerAdapter;
import com.example.myapplication.row_item;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class homepage extends AppCompatActivity {
    public static final String URL_DATA ="https://api.themoviedb.org/3/movie/popular?api_key=4dc0b4988b87a649ec57904fdaed2a9d&language=en-US&page=1";
     RecyclerView recyclerView;
     RecyclerView.Adapter adapter;
     public List<row_item> listitems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);
        recyclerView=findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        listitems=new ArrayList<>();
        loadRecylerViewData();
    }
    private void loadRecylerViewData(){
        ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Loading Data");
        progressDialog.show();
        StringRequest stringRequest=new StringRequest(Request.Method.GET,
                URL_DATA, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressDialog.dismiss();
                try {
                    JSONObject jsonObject=new JSONObject(response);
                    JSONArray array=jsonObject.getJSONArray("results");
                    for(int i=0;i<array.length();i++){
                    JSONObject o=array.getJSONObject(i);
                    row_item item =new row_item(o.getString("original_title"),
                            o.getString("overview"),
                            o.getString("poster_path") );
                    listitems.add(item);
                    }
                    adapter =new RecyclerAdapter(listitems,getApplicationContext() );
                    recyclerView.setAdapter(adapter);
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
}
