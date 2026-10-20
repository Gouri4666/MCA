package com.example.practise;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.*;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText number;
    Button btn;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number = findViewById(R.id.number);
        btn = findViewById(R.id.btn);
        img = findViewById(R.id.img);

        // Initially no image
        img.setImageDrawable(null);

        // Button click: calculate factorial
        btn.setOnClickListener(v -> calculateFactorial());
    }

    // Three-dot options menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 1, 0, "Factorial");
        menu.add(0, 2, 1, "Gender");
        return true;
    }

    // Handle menu selections
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == 1) {
            number.setVisibility(android.view.View.VISIBLE);
            btn.setVisibility(android.view.View.VISIBLE);
            img.setVisibility(android.view.View.GONE);
            return true;
        }

        if (item.getItemId() == 2) {
            number.setVisibility(android.view.View.GONE);
            btn.setVisibility(android.view.View.GONE);
            img.setVisibility(android.view.View.VISIBLE);
            selectGender();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // Factorial calculation and dialog
    private void calculateFactorial() {

        String input = number.getText().toString().trim();

        if (input.isEmpty()) {
            number.setError("Enter a number");
            return;
        }

        int n;

        try {
            n = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            number.setError("Enter a valid number");
            return;
        }

        if (n < 0 || n > 20) {
            number.setError("Enter a number from 0 to 20");
            return;
        }

        long fact = 1;

        for (int i = 1; i <= n; i++) {
            fact = fact * i;
        }

        new AlertDialog.Builder(this)
                .setTitle("Factorial")
                .setMessage(n + "! = " + fact)
                .setPositiveButton("OK", (dialog, which) -> {})
                .setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss())
                .show();
    }

    // Gender selection
    private void selectGender() {

        String[] genders = {"Male", "Female"};

        new AlertDialog.Builder(this)
                .setTitle("Select Gender")
                .setItems(genders, (dialog, which) -> {

                    if (which == 0) {
                        img.setImageResource(R.drawable.boy);
                    } else {
                        img.setImageResource(R.drawable.girl);
                    }

                })
                .setNegativeButton("Cancel", null)
                .show();
    }
}
