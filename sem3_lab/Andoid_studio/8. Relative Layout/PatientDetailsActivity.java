package com.example.calculatorapp;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PatientDetailsActivity extends AppCompatActivity {

    ImageView imgPatient;
    TextView txtName, txtAge, txtGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_patient_details);

        imgPatient = findViewById(R.id.imgPatient);
        txtName = findViewById(R.id.txtName);
        txtAge = findViewById(R.id.txtAge);
        txtGender = findViewById(R.id.txtGender);

        String name = getIntent().getStringExtra("name");
        String age = getIntent().getStringExtra("age");
        String gender = getIntent().getStringExtra("gender");


        txtName.setText("Name:" + name);
        txtAge.setText("Age:" + age);
        txtGender.setText("Gender:" + gender);

        if ("Female".equals(gender)) {

            imgPatient.setImageResource(R.drawable.female);

        } else {

            imgPatient.setImageResource(R.drawable.male);
        }
    }
}
