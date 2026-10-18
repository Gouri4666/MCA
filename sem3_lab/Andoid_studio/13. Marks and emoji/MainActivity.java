package com.example.practise;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText m1, m2, m3;
    Button btn;
    ImageView result;
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        m1 = findViewById(R.id.m1);
        m2 = findViewById(R.id.m2);
        m3 = findViewById(R.id.m3);
        btn = findViewById(R.id.btn);
        result = findViewById(R.id.result);
        txtResult = findViewById(R.id.txtResult);

        btn.setOnClickListener(v -> {

            if (m1.getText().toString().isEmpty() ||
                    m2.getText().toString().isEmpty() ||
                    m3.getText().toString().isEmpty()) {

                Toast.makeText(this, "Enter all marks",
                        Toast.LENGTH_SHORT).show();
                return;
            }

            int a = Integer.parseInt(m1.getText().toString());
            int b = Integer.parseInt(m2.getText().toString());
            int c = Integer.parseInt(m3.getText().toString());

            if (a < 0 || a > 100 ||
                    b < 0 || b > 100 ||
                    c < 0 || c > 100) {

                Toast.makeText(this, "Enter marks from 0 to 100",
                        Toast.LENGTH_SHORT).show();
                return;
            }

            double percentage = (a + b + c) / 3.0;

            if (percentage > 50) {
                result.setImageResource(R.drawable.happy);
                txtResult.setText("PASS");
            } else {
                result.setImageResource(R.drawable.sad);
                txtResult.setText("FAIL");
            }
        });
    }
}
