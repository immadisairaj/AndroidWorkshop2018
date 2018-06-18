package com.example.immad.train;

import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class PNRTask extends AsyncTask<String, Void, JSONObject> {

    @Override
    protected JSONObject doInBackground(String... strings) {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https").authority("api.railwayapi.com")
                .appendPath("v2")
                .appendPath("pnr-status")
                .appendPath("pnr")
                .appendPath(strings[0])
                .appendPath("apikey")
                .appendPath("70wmb5ovkz");
        String URL = builder.build().toString();

        Log.v("Train",URL);

        HttpURLConnection connection = null;
        InputStream is = null;

        try {
            java.net.URL url = new URL(URL);

            connection = (HttpURLConnection) url.openConnection();
            is = connection.getInputStream();

            StringBuffer buffer = new StringBuffer();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));

            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(line + "\n");
            }

            JSONObject obj = new JSONObject(buffer.toString());
            return obj;
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        } catch (IOException iex) {
            iex.printStackTrace();
        } catch (JSONException jex) {
            jex.printStackTrace();
        } finally {
            try {
                is.close();
                connection.disconnect();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }
}
