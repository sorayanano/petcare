package com.example.nano.mypet;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.LruCache;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.common.images.ImageRequest;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.URL;

public class Main13Activity extends AppCompatActivity {
    //ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main13);


        ImageView image = (ImageView) findViewById(R.id.imageView29);
        Picasso.get().load("http://192.168.43.139/image/"+  getIntent().getStringExtra("vac_img")).into(image);
        //Picasso.get().load("http://127.0.0.1/image/logo1.png").into(image);
        //Toast.makeText(Main13Activity.this,vcc_file, Toast.LENGTH_LONG).show();
    }


}
