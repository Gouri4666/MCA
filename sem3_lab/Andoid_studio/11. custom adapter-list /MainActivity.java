
package com.example.practice;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ListView lv;

    String[] names = {"sad", "happy", "angry"};

    int[] images = {
            R.drawable.sad,
            R.drawable.happy,
            R.drawable.angry
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.lv);

        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(
                        this, R.layout.custom, R.id.tv, names) {

                    @Override
                    public View getView(int position, View convertView,
                                        ViewGroup parent) {

                        View v = super.getView(position, convertView, parent);

                        ImageView img = v.findViewById(R.id.img);
                        img.setImageResource(images[position]);

                        return v;
                    }
                };

        lv.setAdapter(adapter);

        lv.setOnItemClickListener((parent, view, position, id) -> {
            Toast.makeText(this, names[position],
                    Toast.LENGTH_SHORT).show();
        });
    }
}
