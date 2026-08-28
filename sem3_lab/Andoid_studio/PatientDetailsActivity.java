package com.example.calculatorapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText edtName, edtAge;
    RadioGroup radioGroupGender;
    RadioButton rbMale, rbFemale;
    CheckBox cbTerms;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        edtName = findViewById(R.id.edtName);
        edtAge = findViewById(R.id.edtAge);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        rbMale = findViewById(R.id.rbMale);
        rbFemale = findViewById(R.id.rbFemale);
        cbTerms = findViewById(R.id.cbTerms);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String name = edtName.getText().toString().trim();
                String age = edtAge.getText().toString().trim();

                int selectedGenderId =
                        radioGroupGender.getCheckedRadioButtonId();

                if (name.isEmpty() || age.isEmpty()) {

                    Toast.makeText(
                            MainActivity.this,
                            "Please enter all details",
                            Toast.LENGTH_SHORT
                    ).show();

                } else if (selectedGenderId == -1) {

                    Toast.makeText(
                            MainActivity.this,
                            "Please select gender",
                            Toast.LENGTH_SHORT
                    ).show();

                } else if (!cbTerms.isChecked()) {

                    Toast.makeText(
                            MainActivity.this,
                            "Please confirm the details",
                            Toast.LENGTH_SHORT
                    ).show();

                } else {

                    String gender;

                    if (rbFemale.isChecked()) {
                        gender = "Female";
                    } else {
                        gender = "Male";
                    }

                    Intent intent = new Intent(
                            MainActivity.this,
                            PatientDetailsActivity.class
                    );

                    intent.putExtra("name", name);
                    intent.putExtra("age", age);
                    intent.putExtra("gender", gender);

                    startActivity(intent);
                }
            }
        });
    }
}
