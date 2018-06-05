package com.niksharma.bitcointracker;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.json.JSONException;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class TaskScheduler extends AsyncTask<Void, Void, String> {
    ProgressBar progress;

    Button button;

    TextView text1, text2, text3, text4;
    AppCompatActivity context;
    private static final String API = "http://api.coindesk.com/v1/bpi/currentprice.json";

    TaskScheduler(ProgressBar progress, Button button, TextView text1, TextView text2, TextView text3, TextView text4, AppCompatActivity context) {
        this.progress = progress;
        this.button = button;
        this.text1 = text1;
        this.text2 = text2;
        this.text3 = text3;
        this.text4 = text4;
        this.context = context;

    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progress.setVisibility(View.VISIBLE);
        button.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void onPostExecute(String s) {
        progress.setVisibility(View.INVISIBLE);
        DataModel obj = null;
        try {
            obj = DataModel.toData(s);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        if (obj != null) {
            text1.setText(obj.getCode());
            text2.setText(obj.getUpdatedDate());
            text3.setText(R.string.price);
            text4.setText(obj.getPrice());


        }


    }

    @Override
    protected String doInBackground(Void... voids) {
        URL url = null;
        StringBuilder response = new StringBuilder("");


        try {
            url = new URL(API);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


        try {

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            Log.i("info", String.valueOf(con.getResponseCode()));
            con.setConnectTimeout(15000);
            con.setReadTimeout(15000);
            con.connect();
            InputStream in = new BufferedInputStream(con.getInputStream());

            int line;
            while ((line = in.read()) != -1) {
                response.append((char) line);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return response.toString();
    }

}

