package com.example.nano.mypet;

import android.app.AlertDialog;
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

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        String url = "http://192.168.43.139/history.php?id="+getIntent().getStringExtra("data_id");

//


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
                                        data_date = response.getString("his_date"),
                                        data_sysptom = response.getString("sysptom"),
                                        data_diagnosis = response.getString("diagnosis"),
                                        data_treatment = response.getString("his_treatment"),
                                        data_doctor = response.getString("doctor");

                                TextView his_date = (TextView)findViewById(R.id.textView);
                                TextView sysptom = (TextView)findViewById(R.id.textView3);
                                TextView his_diagnosis = (TextView)findViewById(R.id.textView8);
                                TextView his_treatment = (TextView)findViewById(R.id.textView9);
                                TextView doctor = (TextView)findViewById(R.id.textView10);


                                his_date.setText(data_date);
                                sysptom.setText(data_sysptom);
                                his_diagnosis.setText(data_diagnosis);
                                his_treatment.setText(data_treatment);
                                doctor.setText(data_doctor);


                            }
                            else if(status == false){
                                Toast.makeText(Main2Activity.this,"Not found", Toast.LENGTH_LONG).show();
                            }
                            else {
                                Toast.makeText(Main2Activity.this,"Error", Toast.LENGTH_LONG).show();
                            }




                        } catch (JSONException e) {
                            //e.printStackTrace();
                            Toast.makeText(Main2Activity.this,e.toString(), Toast.LENGTH_LONG).show();
                        }
                    }
                }, new Response.ErrorListener() {

                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                        Toast.makeText(Main2Activity.this,error.toString(), Toast.LENGTH_LONG).show();
                    }
                });


        Volley.newRequestQueue(Main2Activity.this).add(jsonRequest);
    }

    public void clickHome(View view)
    {
        Intent go = new Intent(Main2Activity.this, Main3Activity.class);
        startActivity(go);
    }
}
