package com.example.ibmemilpalmqvist.slutaappen;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Hämtar startdatum från startactivity
        int yearF = getIntent().getIntExtra("ID_yearFinal", -1);
        int monthF = getIntent().getIntExtra("ID_monthFinal", -1);
        int dayF = getIntent().getIntExtra("ID_dayFinal", -1);
        int hourF = getIntent().getIntExtra("ID_hourFinal", -1);
        int minuteF = getIntent().getIntExtra("ID_minuteFinal", -1);

        //Konverterar dessa till String
        Integer.toString(yearF); Integer.toString(monthF); Integer.toString(dayF);
        Integer.toString(hourF); Integer.toString(minuteF);

        //Bygger en sträng av ovan strängar (Ska vara DateTime format)
        String sb = monthF + " " + dayF + " " + yearF;

        //Hittar och visar strängen i TextView på MainActivity
        final TextView tvTimer = (TextView) findViewById(R.id.tvTimer);
        tvTimer.setText("Funkar inte");

        //Konvertera strängen sb till Date
        //DateFormat format = new SimpleDateFormat("MM dd yyyy");
        //Hämtar datum nu
        //Date dateNow = new Date();

        /*
        Date date = null;
        try {
            date = format.parse(sb);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        tvTimer.setText(sb);
        */

        //long diff = Math.abs(dateNow.getTime() - date.getTime());


        Timer T=new Timer();
        T.scheduleAtFixedRate(new TimerTask() {
            //COUNT SKA HÄR VARA LIKA MYCKET SOM datum - dagens datum
            int count = 0;
            @Override
            public void run() {
                runOnUiThread(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        tvTimer.setText("count="+count);
                        count++;
                    }
                });
            }
        }, 1000, 1000);



    }


}

