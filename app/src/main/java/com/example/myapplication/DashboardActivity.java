package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class DashboardActivity extends Activity {
    private Button logout;
    private TextView click;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);
        logout=findViewById(R.id.logout);
        click=findViewById(R.id.click);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent=new Intent(DashboardActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             Intent intent = new Intent(DashboardActivity.this,homepage.class);
             startActivity(intent);
             finish();
            }
        } );
    }
}
