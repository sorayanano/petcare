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
    }

        public void clickNext(View view)
        {
            Intent go = new Intent(Main6Activity.this, Main7Activity.class);
            startActivity(go);
        }

        public void clickHome(View view)
        {
            Intent go = new Intent(Main6Activity.this, Main3Activity.class);
            startActivity(go);
        }



    }

