package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyAdapter extends ArrayAdapter<String> {

    Context context;
    String[] names;
    int[] images;

    public MyAdapter(Context context, String[] names, int[] images) {

        super(context, R.layout.list_item, names);

        this.context = context;
        this.names = names;
        this.images = images;
    }

    @NonNull
    @Override
    public View getView(
            int position,
            @Nullable View convertView,
            @NonNull ViewGroup parent) {

        if (convertView == null) {

            LayoutInflater inflater =
                    LayoutInflater.from(context);

            convertView = inflater.inflate(
                    R.layout.list_item,
                    parent,
                    false
            );
        }

        ImageView imageView =
                convertView.findViewById(R.id.itemImage);

        TextView textView =
                convertView.findViewById(R.id.itemText);

        imageView.setImageResource(images[position]);

        textView.setText(names[position]);

        return convertView;
    }
}
