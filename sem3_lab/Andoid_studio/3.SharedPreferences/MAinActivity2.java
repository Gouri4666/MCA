package com.example.loginapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {

    Button prev;
    TextView tvWelcome, tvEmail;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        prev = findViewById(R.id.prev);
        tvWelcome = findViewById(R.id.tvWelcome);
        tvEmail = findViewById(R.id.tvEmail);

        prev.setOnClickListener(this);

        sp = getSharedPreferences("MyData", MODE_PRIVATE);

        String name = sp.getString("Name", "");
        String email = sp.getString("Email", "");

        tvWelcome.setText("Hello, " + name);
        tvEmail.setText("Email: " + email);
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(MainActivity2.this, MainActivity.class);
        startActivity(i);
        finish();
    }
}
