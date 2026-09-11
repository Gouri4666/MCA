package com.example.frame_layout;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    ImageView image1;
    ImageView image2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        TextView text = findViewById(R.id.text);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "font/newfont.ttf");
        text.setTypeface(typeface);


        image1=findViewById(R.id.image1);
        image2=findViewById(R.id.image2);
        image1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {
                image1.setVisibility(View.GONE);
                image2.setVisibility(View.VISIBLE);
                text.setVisibility(View.VISIBLE);
            }
        });
        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image2.setVisibility(View.GONE);
                text.setVisibility(View.GONE);
                image1.setVisibility(View.VISIBLE);
            }
        });
    }
}
