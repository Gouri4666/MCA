package com.example.practice;

import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    boolean changing=false;
    ToggleButton toggle;

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


        EditText m;
        TextView tv;
        LinearLayout main;
        CheckBox cb;
        Button submit;

        m=findViewById(R.id.m);
        tv=findViewById(R.id.tv);
        toggle = findViewById(R.id.toggle);
        main = findViewById(R.id.main);
        cb=findViewById(R.id.cb);
        submit=findViewById(R.id.submit);



        toggle.setOnCheckedChangeListener(((buttonView, isChecked) ->
        {
            if(isChecked)
            {
                main.setBackgroundResource(R.drawable.sad);
            }
            else {
                main.setBackgroundResource(R.drawable.happy);
            }
        }));

        submit.setOnClickListener(v->
        {
            if(cb.isChecked())
            {
                return;
            }
            else
            {
                Toast.makeText(this, "Please accept terms and condition", Toast.LENGTH_SHORT).show();
                return;
            }
        });


        m.addTextChangedListener(new TextWatcher() {

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

                if (changing || s.length() == 0) {
                    return;
                }

                double mark = Double.parseDouble(s.toString());

                if (mark > 100) {
                    changing = true;
                    m.setText("100");
                    m.setSelection(m.getText().length());
                    changing = false;
                }
            }
        });



    }
}
