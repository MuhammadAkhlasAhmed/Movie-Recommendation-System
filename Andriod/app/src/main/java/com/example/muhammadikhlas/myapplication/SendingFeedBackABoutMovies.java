package com.example.muhammadikhlas.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by kh on 1/21/2018.
 */

public class SendingFeedBackABoutMovies extends AsyncTask<String,Void,String> {


    Context context;
    public SendingFeedBackABoutMovies(Context context) {
        this.context = context.getApplicationContext();
    }


    HttpURLConnection urlConnection = null;
    URL url = null;
    JSONObject object = null;
    InputStream inStream = null;
    String   urlString="http://192.168.0.109:8081/api/v1/";
    String temp, response = "";
    String mname,status;




    @Override
    protected String doInBackground(String... strings) {
        try {

            String x=strings[0].toString();
            mname=x;
            String y=strings[1].toString();
            status=y;
String iko=""+urlString+x.replace(" ","%20")+"/"+y;

            url = new URL((iko.toString())); //ye update hoga abhi link k hisab se
Log.d("Query",iko);

            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("POST");
            urlConnection.connect();
            inStream = urlConnection.getInputStream();
            BufferedReader bReader = new BufferedReader(new InputStreamReader(inStream));

            while ((temp = bReader.readLine()) != null) {
                response += temp;
            }
            //object = (JSONObject) new JSONTokener(response).nextValue();


        } catch (Exception e) {
            Log.d("Exception",""+e.toString());
        }


        return response;
    }




    @Override
    protected void onPostExecute(String x) {

        Log.d("Responce",x);
        Toast.makeText(context,"Thanks For Giving The Feed Back",Toast.LENGTH_LONG).show();

        Intent ais=new Intent(context,LogoutActivity.class);
        ais.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(ais);



    }






}
