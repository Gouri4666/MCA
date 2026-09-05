package com.example.implicitintent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button map,sentmail,sentimage,gplay;
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
        map=findViewById(R.id.map);
        gplay=findViewById(R.id.gplay);
        sentmail=findViewById(R.id.sentmail);
        sentimage=findViewById(R.id.sentimage);
        map.setOnClickListener(this);
        gplay.setOnClickListener(this);
        sentmail.setOnClickListener(this);
        sentimage.setOnClickListener(this);
    }
    @Override
    public void onClick(View view)
    {
    Intent intent,chooser;
    if(view.getId()==R.id.map)
    {
        intent= new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo:10.065206,76.629128"));
        chooser= Intent.createChooser(intent,"Launch Maps");
        startActivity(chooser);
    }
    if (view.getId()==R.id.gplay)
    {
        intent =new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=gov.nasa"));
        chooser=Intent.createChooser(intent,"Google Play");
        startActivity(chooser);
    }
    if (view.getId()==R.id.sentmail)
        {
            intent =new Intent(Intent.ACTION_SEND);
            String[] to={"gouri03nandana@gmail.com"};
            intent.putExtra(Intent.EXTRA_EMAIL,to);
            intent.putExtra(Intent.EXTRA_SUBJECT,"From Emulator");
            intent.putExtra(Intent.EXTRA_TEXT,"Hello!");
            intent.setType("message/rfc822");
            chooser=Intent.createChooser(intent,"Email Application");
            startActivity(chooser);
        }
    if (view.getId()==R.id.sentimage)
    {
        intent=new Intent(Intent.ACTION_SEND);
        Uri imgUri=Uri.parse("android.resource://"+getPackageName()+"/"+R.drawable.rose);
        intent.setType("image/*");
        intent.putExtra(Intent.EXTRA_STREAM,imgUri);
        intent.putExtra(Intent.EXTRA_TEXT,"I have attached an image");
        chooser=Intent.createChooser(intent,"Share Image");
        startActivity(chooser);
    }
    }
}
