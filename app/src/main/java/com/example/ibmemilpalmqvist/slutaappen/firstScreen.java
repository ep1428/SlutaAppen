package com.example.ibmemilpalmqvist.slutaappen;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import java.util.Calendar;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class firstScreen extends AppCompatActivity implements DatePickerDialog.OnDateSetListener,
        TimePickerDialog.OnTimeSetListener {

    Button btnDateTime;
    TextView tvResult;

    int day, month, year, hour, minute;
    int dayFinal, monthFinal, yearFinal, hourFinal, minuteFinal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_screen);

        btnDateTime = (Button) findViewById(R.id.btnDateTime);
        tvResult = (TextView) findViewById(R.id.tvResult);

        btnDateTime.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                Calendar c = Calendar.getInstance();
                year = c.get(Calendar.YEAR);
                month = c.get(Calendar.MONTH);
                day = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(firstScreen.this,
                        firstScreen.this, year, month, day);
                datePickerDialog.show();




            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        yearFinal = i;
        monthFinal = i1 + 1;
        dayFinal = i2;

        Calendar c = Calendar.getInstance();
        hour = c.get(Calendar.HOUR_OF_DAY);
        minute = c.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(firstScreen.this,
                firstScreen.this, hour, minute, DateFormat.is24HourFormat(this));
        timePickerDialog.show();

    }

    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {
        hourFinal = i;
        minuteFinal = i1;

        tvResult.setText("Year: " + yearFinal + "\n"  + "Month: " + monthFinal  + "\n" +
                "Day: " + dayFinal  + "\n" + "Hour: " + hourFinal  + "\n" + "Minute: " + minuteFinal);

        int yF = yearFinal;
        int mF = monthFinal;
        int dF = dayFinal;
        int hF = hourFinal;
        int minF = minuteFinal;

        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.putExtra("ID_yearFinal", yF);
        intent.putExtra("ID_monthFinal", mF);
        intent.putExtra("ID_dayFinal", dF);
        intent.putExtra("ID_hourFinal", hF);
        intent.putExtra("ID_minuteFinal", minF);
        startActivity(intent);

    }
}
