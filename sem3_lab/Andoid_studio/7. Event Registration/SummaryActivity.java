package com.example.eventregistration;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SummaryActivity extends AppCompatActivity {

    TextView tvSummary;
    Button btnBack, btnConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        tvSummary = findViewById(R.id.tvSummary);
        btnBack = findViewById(R.id.btnBack);
        btnConfirm = findViewById(R.id.btnConfirm);

        // Retrieve data from SharedPreferences
        SharedPreferences sp =
                getSharedPreferences(
                        "Registration",
                        MODE_PRIVATE
                );

        String name = sp.getString("name", "");
        String email = sp.getString("email", "");
        String category = sp.getString("category", "");
        String workshops = sp.getString("workshops", "");

        // Display summary
        String summary =
                "Name: " + name +
                "\n\nEmail: " + email +
                "\n\nCategory: " + category +
                "\n\nWorkshops: " + workshops;

        tvSummary.setText(summary);

        // Back to Edit
        btnBack.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent =
                        new Intent(
                                SummaryActivity.this,
                                MainActivity.class
                        );

                startActivity(intent);

                finish();
            }
        });

        // Confirm Registration
        btnConfirm.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // Inflate custom Toast layout
                LayoutInflater inflater =
                        getLayoutInflater();

                View view =
                        inflater.inflate(
                                R.layout.custom_toast,
                                null
                        );

                Toast toast =
                        new Toast(
                                getApplicationContext()
                        );

                toast.setDuration(Toast.LENGTH_LONG);
                toast.setView(view);
                toast.show();
            }
        });
    }
}