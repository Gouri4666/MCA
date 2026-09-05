package com.example.factorialapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etNumber;
    Button btnFactorial;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNumber = findViewById(R.id.etNumber);
        btnFactorial = findViewById(R.id.btnFactorial);
        tvResult = findViewById(R.id.tvResult);

        btnFactorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int num = Integer.parseInt(etNumber.getText().toString());

                if (num < 0) {
                    Toast.makeText(MainActivity.this,
                            "Error! Enter a positive number.",
                            Toast.LENGTH_SHORT).show();
                } else {
                    long fact = 1;

                    for (int i = 1; i <= num; i++) {
                        fact = fact * i;
                    }

                    tvResult.setText("Factorial = " + fact);
                }
            }
        });
    }
}
