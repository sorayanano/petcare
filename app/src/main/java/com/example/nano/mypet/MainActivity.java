package com.example.nano.mypet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main11);
        Button next = (Button) findViewById(R.id.bt);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent i = new Intent(MainActivity.this ,Main3Activity.class);
                startActivity(i);


            }
        });
    }
}
