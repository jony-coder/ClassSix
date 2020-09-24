package com.example.classsix;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.icu.text.CaseMap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class SecondActivity extends AppCompatActivity {

    private TextView textView;
    private Button dateButton, timeButton;
    private TextView dateText, timeText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setTitle("Second Activity");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        textView=(TextView)findViewById(R.id.textViewId);
        dateButton=(Button)findViewById(R.id.dateButtonId);
        timeButton=(Button)findViewById(R.id.timeButtonId);
        dateText=(TextView)findViewById(R.id.dateTextId);
        timeText=(TextView)findViewById(R.id.timeTextId);

        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePicker datePicker = new DatePicker(SecondActivity.this);
                int day= datePicker.getDayOfMonth();
                int month= datePicker.getMonth();
                int year= datePicker.getYear();

                DatePickerDialog datePickerDialog = new DatePickerDialog(SecondActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        month = month +1;

                        dateText.setText("Date: "+day+"/"+month+"/"+year);
                    }
                }, year, day, month);

                datePickerDialog.show();

            }
        });

        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                TimePicker timePicker = new TimePicker(SecondActivity.this);
                int hour = timePicker.getHour();
                int min = timePicker.getMinute();
                TimePickerDialog timePickerDialog = new TimePickerDialog(SecondActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override

                    public void onTimeSet(TimePicker timePicker, int Hour, int Min) {
                        timeText.setText("Time: "+Hour+":"+Min);

                    }
                }, hour, min, false);

                timePickerDialog.show();
            }
        });

        String value = getIntent().getStringExtra("key");
        if(value.equals("one")){
            textView.setText("come from button one");
        }
        else if(value.equals("two")){
            textView.setText("come from button two");
        }

    }
}