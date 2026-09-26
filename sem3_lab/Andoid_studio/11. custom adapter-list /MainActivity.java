package com.example.myapplication;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    String[] names = {
            "Apple",
            "Berry",
            "Mango",
            "Melon",
            "Orange"
    };

    int[] images = {
            R.drawable.apple,
            R.drawable.berry,
            R.drawable.mango,
            R.drawable.melon,
            R.drawable.orange
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        MyAdapter adapter = new MyAdapter(
                this,
                names,
                images
        );

        listView.setAdapter(adapter);
    }
}
