package com.example.nano.mypet;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Main5Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);



        String url = "http://192.168.43.139/info.php?id="+getIntent().getStringExtra("data_id");

//        AlertDialog alertDialog = new AlertDialog.Builder(Main5Activity.this).create();
//        alertDialog.setTitle("Alert");
//        alertDialog.setMessage(url);
//        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
//                new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.dismiss();
//                    }
//                });
//        alertDialog.show();

        //user.setText(url);
        JsonObjectRequest jsonRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    public void onResponse(JSONObject response) {


                        // the response is already constructed as a JSONObject!
                        try {
                            response = response.getJSONObject("data");


                            boolean status = Boolean.valueOf(response.getString("status"));
                            if(status == true){
                                String
                                        data_name = response.getString("pet_name"),
                                        data_breed = response.getString("pet_breed"),
                                data_sex = response.getString("sex"),
                                data_user = response.getString("user"),
                                data_tel = response.getString("tel");

                                TextView pet_name = (TextView)findViewById(R.id.textView2);
                                TextView pet_breed = (TextView)findViewById(R.id.textView5);
                                TextView sex = (TextView)findViewById(R.id.textView4);
                                TextView user = (TextView)findViewById(R.id.textView6);
                                TextView tel = (TextView)findViewById(R.id.textView7);

                                pet_name.setText(data_name);
                                pet_breed.setText(data_breed);
                                sex.setText(data_sex);
                                user.setText(data_user);
                                tel.setText(data_tel);

                            }
                            else if(status == false){
                                Toast.makeText(Main5Activity.this,"Not found", Toast.LENGTH_LONG).show();
                            }
                            else {
                                Toast.makeText(Main5Activity.this,"Error", Toast.LENGTH_LONG).show();
                            }




                        } catch (JSONException e) {
                            //e.printStackTrace();
                            Toast.makeText(Main5Activity.this,e.toString(), Toast.LENGTH_LONG).show();
                        }
                    }
                }, new Response.ErrorListener() {

                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                        Toast.makeText(Main5Activity.this,error.toString(), Toast.LENGTH_LONG).show();
                    }
                });


        Volley.newRequestQueue(Main5Activity.this).add(jsonRequest);
    }
    public void clickNext(View view)
    {
        Intent go = new Intent(Main5Activity.this, Main2Activity.class);

        go.putExtra("data_id", getIntent().getStringExtra("data_id"));
        startActivity(go);
    }

    public void clickHome(View view)
    {
        Intent go = new Intent(Main5Activity.this, Main3Activity.class);
        startActivity(go);
    }
}
