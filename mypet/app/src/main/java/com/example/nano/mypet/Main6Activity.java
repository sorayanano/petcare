package com.example.nano.mypet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Main6Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        ImageView imageView13;
            imageView13 = findViewById(R.id.imageView13);
        imageView13.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view)
                {
                    Intent go = new Intent(getApplicationContext(), Main7Activity.class);
                    startActivity(go);
                }

        });



    }
}
