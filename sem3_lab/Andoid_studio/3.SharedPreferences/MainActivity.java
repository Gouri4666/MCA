package com.example.sharedapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText name,email;
    Button submit;
    String a;
    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        name=(EditText) findViewById(R.id.name);
        email=(EditText) findViewById(R.id.email);
        submit=(Button) findViewById(R.id.submit);
        submit.setOnClickListener(this);
        sp=getSharedPreferences("MyData",MODE_PRIVATE);
        if (sp.contains("Name")) name.setText(sp.getString("Name",""));
    }
    @Override
    public void onClick(View v)
    {
        a=name.getText().toString();
        SharedPreferences.Editor editor=sp.edit();
        editor.putString("Name",a);
        editor.apply();
        Intent i=new Intent(this, SharedApp2.class);
        startActivity(i);
    }
}
