package com.example.nano.mypet;

import android.content.Intent;
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

public class Main11Activity extends AppCompatActivity {

    EditText user, pass;
    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main11);

        user = (EditText) findViewById(R.id.user);
        pass = (EditText) findViewById(R.id.pass);
        Button clickButton = (Button) findViewById(R.id.bt);
        clickButton.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                final String url = "http://192.168.43.139/login.php?user="+user.getText().toString()+"&pass="+pass.getText().toString();
                //user.setText(url);
                JsonObjectRequest jsonRequest = new JsonObjectRequest
                        (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                            public void onResponse(JSONObject response) {


                                // the response is already constructed as a JSONObject!
                                try {
                                    response = response.getJSONObject("data");
                                    String data_id = response.getString("id");

                            Boolean chk_status = Boolean.valueOf(response.getString("status"));
                                    if(chk_status == true){

                                        //Toast.makeText(Main11Activity.this,response.getString("id"), Toast.LENGTH_LONG).show();

                                        Intent go=new Intent(Main11Activity.this, Main3Activity.class);


                                        go.putExtra("data_id", data_id);

                                        startActivity(go);

//                                        Toast.makeText(Main11Activity.this,"Firstname: "+data_id+" Lastname:"+data_user , Toast.LENGTH_LONG).show();
                                    }
                                    else {
                                        Toast.makeText(Main11Activity.this,"Not found", Toast.LENGTH_LONG).show();
                                    }
//user.setText(response.getString("status"));



                                } catch (JSONException e) {
                                    //e.printStackTrace();
                                    Toast.makeText(Main11Activity.this,e.toString(), Toast.LENGTH_LONG).show();
                                }
                            }
                        }, new Response.ErrorListener() {

                            public void onErrorResponse(VolleyError error) {
                                error.printStackTrace();
                                Toast.makeText(Main11Activity.this,error.toString(), Toast.LENGTH_LONG).show();
                            }
                        });


                Volley.newRequestQueue(Main11Activity.this).add(jsonRequest);
            }
        });
    }
}

/*
        EditText user = (EditText) findViewById(R.id.user);
        EditText pass = (EditText) findViewById(R.id.pass);

        String url = "http://172.20.10.2/login.php?user="+user+"&pass="+pass;
        JsonObjectRequest jsonRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    public void onResponse(JSONObject response) {

                        Toast.makeText(Main11Activity.this,"B", Toast.LENGTH_LONG).show();


                        // the response is already constructed as a JSONObject!
                        try {
                            response = response.getJSONObject("data");

                            if(response.getString("status") == "true"){
                                String data_id = response.getString("id"),
                                        data_firstname = response.getString("firstname"),
                                        data_lastname = response.getString("lastname");
                                //startActivity(new Intent(LoginActivity.this, Main3Activity.class));

                                Intent go=new Intent(Main11Activity.this, Main3Activity.class);
                                go.putExtra(data_id, data_id);
                                go.putExtra(data_firstname, data_firstname);
                                go.putExtra(data_lastname, data_lastname);
                            startActivity(go);
                                Toast.makeText(Main11Activity.this,"Firstname: "+data_firstname+" Lastname:"+data_lastname , Toast.LENGTH_LONG).show();
                            }
                            else {
                                Toast.makeText(Main11Activity.this,"Not found", Toast.LENGTH_LONG).show();
                            }




                        } catch (JSONException e) {
                            //e.printStackTrace();
                            Toast.makeText(Main11Activity.this,e.toString(), Toast.LENGTH_LONG).show();
                        }
                    }
                }, new Response.ErrorListener() {

                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                        Toast.makeText(Main11Activity.this,error.toString(), Toast.LENGTH_LONG).show();
                    }
                });


        Volley.newRequestQueue(Main11Activity.this).add(jsonRequest);
*/
