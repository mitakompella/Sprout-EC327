package com.example.sprout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class listviewdata extends AppCompatActivity {

    TextView name;
    ImageView image;
    ImageView myplantinfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listviewdata);


        name = findViewById(R.id.plants);
        image = findViewById(R.id.images);
        myplantinfo = findViewById(R.id.plantinfo);


        Intent intent = getIntent();
        name.setText(intent.getStringExtra("name"));
        image.setImageResource(intent.getIntExtra("image", 0));
        myplantinfo.setImageResource(intent.getIntExtra("info", 0));

    }
}