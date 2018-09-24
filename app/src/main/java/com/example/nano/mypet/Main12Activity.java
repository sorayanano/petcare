package com.example.nano.mypet;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class     Main12Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main12);

        String url = "http://192.168.43.139/vaccination.php?id=" + getIntent().getStringExtra("data_id");

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
                            if (status == true) {
                                String
                                        data_date = response.getString("vac_date"),
                                        data_vac = response.getString("next_vac"),
                                        data_doc = response.getString("vac_doc"),
                                        data_lot = response.getString("vac_lot"),
                                        data_date1 = response.getString("vac_date1"),
                                        data_vac1 = response.getString("next_vac1"),
                                        data_doc1 = response.getString("vac_doc1"),
                                        data_lot1 = response.getString("vac_lot1"),
                                        data_date2 = response.getString("vac_date2"),
                                        data_vac2 = response.getString("next_vac2"),
                                        data_doc2 = response.getString("vac_doc2"),
                                        data_lot2 = response.getString("vac_lot2"),
                                        data_date3 = response.getString("vac_date3"),
                                        data_vac3 = response.getString("next_vac3"),
                                        data_doc3 = response.getString("vac_doc3"),
                                        data_lot3 = response.getString("vac_lot3");

                                        vac_img_1 = response.getString("vac_img_1");
                                        vac_img_2 = response.getString("vac_img_2");
                                        vac_img_3 = response.getString("vac_img_3");
                                        vac_img_4 = response.getString("vac_img_4");



                                TextView vac_date = (TextView) findViewById(R.id.textView35);
                                TextView next_vac = (TextView) findViewById(R.id.textView36);
                                TextView vac_doc = (TextView) findViewById(R.id.textView39);
                                TextView vac_lot = (TextView) findViewById(R.id.textView37);
                                TextView vac_date1 = (TextView) findViewById(R.id.textView41);
                                TextView next_vac1 = (TextView) findViewById(R.id.textView42);
                                TextView vac_doc1 = (TextView) findViewById(R.id.textView43);
                                TextView vac_lot1 = (TextView) findViewById(R.id.textView44);
                                TextView vac_date2 = (TextView) findViewById(R.id.textView45);
                                TextView next_vac2 = (TextView) findViewById(R.id.textView46);
                                TextView vac_doc2 = (TextView) findViewById(R.id.textView47);
                                TextView vac_lot2 = (TextView) findViewById(R.id.textView48);
                                TextView vac_date3 = (TextView) findViewById(R.id.textView49);
                                TextView next_vac3 = (TextView) findViewById(R.id.textView50);
                                TextView vac_doc3 = (TextView) findViewById(R.id.textView52);
                                TextView vac_lot3 = (TextView) findViewById(R.id.textView53);


                                vac_date.setText(data_date);
                                next_vac.setText(data_vac);
                                vac_doc.setText(data_doc);
                                vac_lot.setText(data_lot);
                                vac_date1.setText(data_date1);
                                next_vac1.setText(data_vac1);
                                vac_doc1.setText(data_doc1);
                                vac_lot1.setText(data_lot1);
                                vac_date2.setText(data_date2);
                                next_vac2.setText(data_vac2);
                                vac_doc2.setText(data_doc2);
                                vac_lot2.setText(data_lot2);
                                vac_date3.setText(data_date3);
                                next_vac3.setText(data_vac3);
                                vac_doc3.setText(data_doc3);
                                vac_lot3.setText(data_lot3);


                            } else if (status == false) {
                                Toast.makeText(Main12Activity.this, "Not found", Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(Main12Activity.this, "Error", Toast.LENGTH_LONG).show();
                            }


                        } catch (JSONException e) {
                            //e.printStackTrace();
                            Toast.makeText(Main12Activity.this, e.toString(), Toast.LENGTH_LONG).show();
                        }
                    }
                }, new Response.ErrorListener() {

                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                        Toast.makeText(Main12Activity.this, error.toString(), Toast.LENGTH_LONG).show();
                    }
                });


        Volley.newRequestQueue(Main12Activity.this).add(jsonRequest);
    }


    public void clickNext(View view) {
        Intent go = new Intent(Main12Activity.this, Main2Activity.class);

        go.putExtra("data_id", getIntent().getStringExtra("data_id"));
        startActivity(go);
    }

    public void clickHome(View view) {
        Intent go = new Intent(Main12Activity.this, Main3Activity.class);
        startActivity(go);
    }
    String vac_img_1,vac_img_2,vac_img_3,vac_img_4;

    public void onClick1(View v) {
        Intent go = new Intent(Main12Activity.this, Main13Activity.class);
        go.putExtra("vac_img", vac_img_1);
        startActivity(go);
    }
    public void onClick2(View v) {
        Intent go = new Intent(Main12Activity.this, Main13Activity.class);
        go.putExtra("vac_img", vac_img_2);
        startActivity(go);
    }
    public void onClick3(View v) {
        Intent go = new Intent(Main12Activity.this, Main13Activity.class);
        go.putExtra("vac_img", vac_img_3);
        startActivity(go);
    }
    public void onClick4(View v) {
        Intent go = new Intent(Main12Activity.this, Main13Activity.class);
        go.putExtra("vac_img", vac_img_4);
        startActivity(go);
    }
}


