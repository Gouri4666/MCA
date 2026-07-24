package com.example.sharedapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SharedApp2 extends AppCompatActivity implements View.OnClickListener {
    Button prev;
    TextView t;
    SharedPreferences sp;

    @SuppressLint({"MissingInflatedId", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_shared_app2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        prev=(Button) findViewById((R.id.prev));
        prev.setOnClickListener(this);
        sp=getSharedPreferences("MyData",MODE_PRIVATE);

        t=(TextView) findViewById(R.id.namestring);
        if (sp.contains("Name"))
            t.setText("WELCOME "+sp.getString("Name",""));

    }
    @Override
    public void onClick(View v)
    {
        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);
    }
}
