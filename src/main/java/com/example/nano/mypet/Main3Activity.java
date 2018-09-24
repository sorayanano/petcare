package com.example.nano.mypet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        ImageView imageView10;
        imageView10 = findViewById(R.id.imageView10);
        imageView10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent go = new Intent(getApplicationContext(), Main4Activity.class);
                startActivity(go);
            }

        });


        ImageView imageView3;
        imageView3 = findViewById(R.id.imageView3);
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent go = new Intent(getApplicationContext(), MapsActivity.class);
                startActivity(go);
            }

        });

        ImageView imageView12;
        imageView12 = findViewById(R.id.imageView12);
        imageView12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent go = new Intent(getApplicationContext(), Main5Activity.class);
                startActivity(go);
            }

        });

        ImageView imageView9;
        imageView9 = findViewById(R.id.imageView9);
        imageView9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent go = new Intent(getApplicationContext(), Main6Activity.class);
                startActivity(go);
            }

        });

        ImageView imageView11;
        imageView11 = findViewById(R.id.imageView11);
        imageView11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent go = new Intent(getApplicationContext(), Main10Activity.class);
                startActivity(go);
            }

        });

    }

}



