package com.example.nano.mypet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {

    //String data_id = "1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

//       Toast.makeText(Main3Activity.this,getIntent().getStringExtra("data_id"),Toast.LENGTH_LONG).show();

    }

        public void click4 (View view)
        {
            Intent go = new Intent(Main3Activity.this, Main4Activity.class);

            go.putExtra("data_id", getIntent().getStringExtra("data_id"));
            startActivity(go);
        }

    public void click5(View view)
    {
        Intent go = new Intent(Main3Activity.this, Main5Activity.class);

        go.putExtra("data_id", getIntent().getStringExtra("data_id"));
        startActivity(go);
    }

    public void click6(View view)
    {
        Intent go = new Intent(Main3Activity.this, Main6Activity.class);
        startActivity(go);
    }
    public void clickmap(View view)
    {
        Intent go = new Intent(Main3Activity.this, MapsActivity.class);
        startActivity(go);
    }
    public void click10(View view)
    {
        Intent go = new Intent(Main3Activity.this, Main10Activity.class);
        startActivity(go);
    }
    public void click12(View view)
    {
        Intent go = new Intent(Main3Activity.this, Main12Activity.class);

        go.putExtra("data_id", getIntent().getStringExtra("data_id"));
        startActivity(go);
    }

    public void clicklog(View view)
    {
        Intent go = new Intent(Main3Activity.this, Main11Activity.class);

        startActivity(go);
    }



}



