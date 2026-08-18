package com.example.eventregistration;

import android.content.Intent;
import android.content.SharedPreferences;
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

    EditText etName, etEmail;
    RadioGroup radioGroup;
    RadioButton rbStudent, rbProfessional;
    CheckBox cbAndroid, cbAI, cbCyber;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Connect XML components with Java
        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);

        radioGroup = findViewById(R.id.radioGroup);
        rbStudent = findViewById(R.id.rbStudent);
        rbProfessional = findViewById(R.id.rbProfessional);

        cbAndroid = findViewById(R.id.cbAndroid);
        cbAI = findViewById(R.id.cbAI);
        cbCyber = findViewById(R.id.cbCyber);

        btnSubmit = findViewById(R.id.btnSubmit);

        // Submit button click
        btnSubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String name = etName.getText().toString().trim();
                String email = etEmail.getText().toString().trim();

                // Validate name and email
                if (name.isEmpty() || email.isEmpty()) {

                    Toast.makeText(
                            MainActivity.this,
                            "Please enter Name and Email",
                            Toast.LENGTH_SHORT
                    ).show();

                    return;
                }

                // Get selected RadioButton
                int selectedId = radioGroup.getCheckedRadioButtonId();

                if (selectedId == -1) {

                    Toast.makeText(
                            MainActivity.this,
                            "Please select a category",
                            Toast.LENGTH_SHORT
                    ).show();

                    return;
                }

                RadioButton selectedRadio =
                        findViewById(selectedId);

                String category =
                        selectedRadio.getText().toString();

                // Get selected workshops
                StringBuilder workshops =
                        new StringBuilder();

                if (cbAndroid.isChecked()) {
                    workshops.append("Android Development, ");
                }

                if (cbAI.isChecked()) {
                    workshops.append("AI & ML, ");
                }

                if (cbCyber.isChecked()) {
                    workshops.append("Cybersecurity, ");
                }

                // Check whether at least one workshop is selected
                if (workshops.length() == 0) {

                    Toast.makeText(
                            MainActivity.this,
                            "Please select at least one workshop",
                            Toast.LENGTH_SHORT
                    ).show();

                    return;
                }

                // Remove the last comma and space
                workshops.setLength(workshops.length() - 2);

                // SharedPreferences
                SharedPreferences sp =
                        getSharedPreferences(
                                "Registration",
                                MODE_PRIVATE
                        );

                SharedPreferences.Editor editor =
                        sp.edit();

                editor.putString("name", name);
                editor.putString("email", email);
                editor.putString("category", category);
                editor.putString(
                        "workshops",
                        workshops.toString()
                );

                editor.apply();

                // Move to Summary Activity
                Intent intent =
                        new Intent(
                                MainActivity.this,
                                SummaryActivity.class
                        );

                startActivity(intent);
            }
        });
    }
}