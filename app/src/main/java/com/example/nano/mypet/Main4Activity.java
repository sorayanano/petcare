package com.example.nano.mypet;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;

import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;


public class Main4Activity extends AppCompatActivity {
    Button btn;
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main4);

        btn = (Button)findViewById(R.id.noti);

        String url = "http://192.168.43.139/meet.php?id="+getIntent().getStringExtra("data_id");

//        AlertDialog alertDialog = new AlertDialog.Builder(Main4Activity.this).create();
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
                                        data_day = response.getString("meetday"),
                                        data_time = response.getString("time"),
                                        data_place = response.getString("place"),
                                        data_doc = response.getString("name_doc");


                                TextView meetday = (TextView)findViewById(R.id.textView11);
                                TextView time = (TextView)findViewById(R.id.textView12);
                                TextView place = (TextView)findViewById(R.id.textView13);
                                TextView name_doc = (TextView)findViewById(R.id.textView14);


                                meetday.setText(data_day);
                                time.setText(data_time);
                                place.setText(data_place);
                                name_doc.setText(data_doc);

                            }
                            else if(status == false){
                                Toast.makeText(Main4Activity.this,"Not found", Toast.LENGTH_LONG).show();
                            }
                            else {
                                Toast.makeText(Main4Activity.this,"Error", Toast.LENGTH_LONG).show();
                            }




                        } catch (JSONException e) {
                            //e.printStackTrace();
                            Toast.makeText(Main4Activity.this,e.toString(), Toast.LENGTH_LONG).show();
                        }
                    }
                }, new Response.ErrorListener() {

                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                        Toast.makeText(Main4Activity.this,error.toString(), Toast.LENGTH_LONG).show();
                    }
                });


        Volley.newRequestQueue(Main4Activity.this).add(jsonRequest);
    }
    public void clickNext(View view)
    {
        Intent go = new Intent(Main4Activity.this, Main2Activity.class);

        go.putExtra("data_id", getIntent().getStringExtra("data_id"));
        startActivity(go);
    }

    public void clickHome(View view)
    {
        Intent go = new Intent(Main4Activity.this, Main3Activity.class);
        startActivity(go);
    }





    public void getnotification(View view)
    {
        Toast.makeText(Main4Activity.this,"กรุณาเลื่อนหน้าจอลงเพื่อรับการแจ้งเดือน", Toast.LENGTH_LONG).show();

        NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        Intent intent = new Intent(this, Main4Activity.class);
        intent.putExtra("data_id", getIntent().getStringExtra("data_id"));


        PendingIntent pintent = PendingIntent.getActivities(this,(int) System.currentTimeMillis(), new Intent[]{intent},0);
      //  PendingIntent pintent = PendingIntent.getActivities(this,(int) System.currentTimeMillis(),intent,0);


        Notification notif = new Notification.Builder(this)
                .setSmallIcon(R.drawable.home)
                .setContentTitle("Hello nano")
                .setContentText("nano notofication")
                .setContentIntent(pintent)
                .build();
        notificationManager.notify(0,notif);

    }

}
