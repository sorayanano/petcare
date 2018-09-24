package com.example.nano.mypet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main9Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);
    }
    public void clickBack(View view)
    {
        Intent go = new Intent(Main9Activity.this, Main8Activity.class);
        startActivity(go);
    }

    public void clickHome(View view)
    {
        Intent go = new Intent(Main9Activity.this, Main3Activity.class);
        startActivity(go);
    }
}

