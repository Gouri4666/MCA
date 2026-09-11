package com.example.listview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    ListView daysList;

    String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_main);
        daysList = findViewById(R.id.daysList);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, days);
        daysList.setAdapter(adapter);
        daysList.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        LayoutInflater inflater = getLayoutInflater();
                        View toastView = inflater.inflate(R.layout.custom_toast, null);
                        TextView toastText = toastView.findViewById(R.id.toastText);
                        toastText.setText(days[position] +":"+position);
                        Toast toast = new Toast(MainActivity.this);
                        toast.setView(toastView);
                        toast.setDuration(Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }
        );
    }
}
