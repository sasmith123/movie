package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity {
    TextView name,role,name2,date;
    ImageView image1;
    String pname,prole,imageurl,pdesc,pdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        name=findViewById(R.id.name);
        role=findViewById(R.id.role);
        image1=findViewById(R.id.image1);
        name2=findViewById(R.id.name2);
        date=findViewById(R.id.date);
        pname=getIntent().getStringExtra("name");
        prole=getIntent().getStringExtra("role");
        imageurl=getIntent().getStringExtra("image");
        pdesc=getIntent().getStringExtra("desc1");
        pdate=getIntent().getStringExtra("date");
        name.setText(pname);
        role.setText(prole);
        name2.setText(pdesc);
        date.setText(pdate);
        Picasso.with(this)
                .load("https://image.tmdb.org/t/p/w500"+imageurl)
                .into(image1);


    }
}