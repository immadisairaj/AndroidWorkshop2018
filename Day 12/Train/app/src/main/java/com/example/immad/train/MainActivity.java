package com.example.immad.train;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    TextView showText;
    Button live, pnr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showText = findViewById(R.id.show_text);
        live = findViewById(R.id.live);
        pnr = findViewById(R.id.pnr);

        liveStatus();
        pnrStatus();
    }

    public void liveStatus() {
        live.setOnClickListener((view) -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            LayoutInflater inflater = getLayoutInflater();
            View dialogueView = inflater.inflate(R.layout.layout_train, null);
            builder.setView(dialogueView);

            final EditText Search = dialogueView.findViewById(R.id.train_num);

            builder.setPositiveButton("Ok", (dialog, witch) -> {
                String train_live = Search.getText().toString();
                if (!train_live.isEmpty()) {
                    getLive(new String[]{train_live});
                } else {
                    dialog.dismiss();
                }
            });

            builder.setTitle("Train Number");

            builder.setMessage("Please Enter a Train Number to get Live Status");

            builder.setNegativeButton("Cancel", (dialogue, witch) -> {
                dialogue.dismiss();
            });

            AlertDialog alert = builder.create();
            alert.show();
        });
    }

    private void getLive(String[] args) {
        JSONObject status = null;

        LiveTask task = new LiveTask();
        try {
            status = task.execute(args[0]).get();
        } catch (InterruptedException iex) {
            iex.printStackTrace();
        } catch (ExecutionException ex) {
            ex.printStackTrace();
        }

        try {
            String main = status.getString("position");
            String trainName = status.getJSONObject("train").getString("name");
            String trainNumber = status.getJSONObject("train").getString("number");

            String display = "Train Name : " + trainName + "\n" +
                    "Train Number : " + trainNumber + "\n" +
                    main;
            showText.setText(display);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void pnrStatus() {
        pnr.setOnClickListener((view) -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            LayoutInflater inflater = getLayoutInflater();
            View dialogueView = inflater.inflate(R.layout.layout_pnr, null);
            builder.setView(dialogueView);

            final EditText Search = dialogueView.findViewById(R.id.pnr_num);

            builder.setPositiveButton("Ok", (dialog, witch) -> {
                String train_pnr = Search.getText().toString();
                if (!train_pnr.isEmpty()) {
                    getPnr(new String[]{train_pnr});
                } else {
                    dialog.dismiss();
                }
            });

            builder.setTitle("PNR Number");

            builder.setMessage("Please Enter a PNR Number to get PNR Status");

            builder.setNegativeButton("Cancel", (dialogue, witch) -> {
                dialogue.dismiss();
            });

            AlertDialog alert = builder.create();
            alert.show();
        });
    }

    private void getPnr(String[] args) {
        JSONObject status = null;

        PNRTask task = new PNRTask();
        try {
            status = task.execute(args[0]).get();
        } catch (InterruptedException iex) {
            iex.printStackTrace();
        } catch (ExecutionException ex) {
            ex.printStackTrace();
        }

        try {
            String main = status.getString("pnr");
            String trainName = status.getJSONObject("train").getString("name");
            String trainNumber = status.getJSONObject("train").getString("number");
            int passengers = status.getInt("total_passengers");
            String bookingStatus = status.getJSONArray("passengers").getJSONObject(0).getString("booking_status");
            String currentStatus = status.getJSONArray("passengers").getJSONObject(0).getString("current_status");
            String from = status.getJSONObject("boarding_point").getString("name");
            String to = status.getJSONObject("reservation_upto").getString("name");

            String display = "PNR : " + main + "\n" +
                    "Train Name : " + trainName + "\n" +
                    "Train Number : " + trainNumber + "\n" +
                    "No. Of Passengers : " + passengers + "\n" +
                    "Booking Status : " + bookingStatus + "\n" +
                    "Current Status : " + currentStatus + "\n" +
                    "Boarding : " + from + "\n" +
                    "Destination : " + to;
            showText.setText(display);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_train, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.share) {
            share();
        }
        return super.onOptionsItemSelected(item);
    }

    public void share() {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        String text = showText.getText().toString();
        shareIntent.putExtra(Intent.EXTRA_TEXT, text);
        startActivity(Intent.createChooser(shareIntent, "Share via"));
    }
}
