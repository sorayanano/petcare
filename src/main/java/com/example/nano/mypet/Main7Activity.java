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

//        ImageView imageView7, imageView5;
//        imageView7 = findViewById(R.id.imageView7);
//        imageView5 = findViewById(R.id.imageView5);

    }//OnCreate

        public void clickNext(View view)
        {
            Intent go = new Intent(Main7Activity.this, Main8Activity.class);
            startActivity(go);
        }


        public void clickBack(View view)
        {
            Intent go = new Intent(Main7Activity.this, Main6Activity.class);
            startActivity(go);
        }

    public void clickHome(View view)
    {
        Intent go = new Intent(Main7Activity.this, Main3Activity.class);
        startActivity(go);
    }



}//MainMethod
