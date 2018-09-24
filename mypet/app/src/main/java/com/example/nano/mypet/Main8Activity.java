package com.example.nano.mypet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Main8Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);

        ImageView imageView15;
        imageView15 = findViewById(R.id.imageView15);
        imageView15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent go = new Intent(getApplicationContext(), Main9Activity.class);
                startActivity(go);
            }

        });
    }
}
