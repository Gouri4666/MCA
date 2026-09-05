package com.example.calculatorapp;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button clickMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        clickMe = findViewById(R.id.clickMe);

        clickMe.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                LayoutInflater inflater = getLayoutInflater();

                View layout = inflater.inflate(
                        R.layout.toast_layout,
                        null
                );

                TextView t1 = layout.findViewById(R.id.t1);

                t1.setText("Button Clicked!");

                Toast toast = new Toast(getApplicationContext());

                toast.setGravity(
                        Gravity.TOP,
                        0,
                        200
                );

                toast.setDuration(Toast.LENGTH_LONG);

                toast.setView(layout);

                toast.show();
            }
        });
    }
}
