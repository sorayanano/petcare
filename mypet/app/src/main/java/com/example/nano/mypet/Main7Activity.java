package com.example.nano.mypet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Main7Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        ImageView imageView4;
        imageView4 = findViewById(R.id.imageView4);
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent go = new Intent(getApplicationContext(), Main8Activity.class);
                startActivity(go);
            }

        });
    }
}
