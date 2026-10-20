package com.example.practise;

import android.os.Bundle;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText percentage;
    CheckBox terms;
    ToggleButton toggle;
    Button submit;
    TextView result;
    LinearLayout layout;

    boolean isUpdating = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        percentage = findViewById(R.id.percentage);
        terms = findViewById(R.id.terms);
        toggle = findViewById(R.id.toggle);
        submit = findViewById(R.id.submit);
        result = findViewById(R.id.result);
        layout = findViewById(R.id.mainLayout);

        // Immediately limit percentage to 100
        percentage.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(
                    CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(
                    CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {

                if (isUpdating || s.length() == 0) {
                    return;
                }

                try {
                    double value = Double.parseDouble(s.toString());

                    if (value > 100) {
                        isUpdating = true;
                        percentage.setText("100");
                        percentage.setSelection(
                                percentage.getText().length());
                        isUpdating = false;
                    }

                } catch (NumberFormatException e) {
                    // Ignore incomplete numeric input
                }
            }
        });

        // Toggle background image
        toggle.setOnCheckedChangeListener((button, checked) -> {
            if (checked) {
                layout.setBackgroundResource(R.drawable.image1);
            } else {
                layout.setBackgroundColor(Color.WHITE);
            }
        });

        // Submit and validate
        submit.setOnClickListener(v -> {

            String input = percentage.getText().toString().trim();

            if (input.isEmpty()) {
                percentage.setError("Enter percentage");
                return;
            }

            double p;

            try {
                p = Double.parseDouble(input);
            } catch (NumberFormatException e) {
                percentage.setError("Enter a valid percentage");
                return;
            }

            if (Double.isNaN(p) || Double.isInfinite(p) || p < 0) {
                percentage.setError("Enter a valid percentage from 0 to 100");
                return;
            }

            if (p > 100) {
                p = 100;
                percentage.setText("100");
            }

            if (!terms.isChecked()) {
                Toast.makeText(this,
                        "Please accept Terms and Conditions",
                        Toast.LENGTH_SHORT).show();
                return;
            }

            result.setText("Percentage: " + p + "%\nTerms Accepted");
        });
    }

    // Options menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 1, 0, "Reset");
        menu.add(0, 2, 1, "Exit");
        return true;
    }

    // Menu actions
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == 1) {
            percentage.setText("");
            terms.setChecked(false);
            toggle.setChecked(false);
            result.setText("");
            return true;
        }

        if (item.getItemId() == 2) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
