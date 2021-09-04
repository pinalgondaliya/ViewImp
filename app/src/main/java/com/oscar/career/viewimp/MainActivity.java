package com.oscar.career.viewimp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.timepicker.MaterialTimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
   Button datepicker;
   Button timepicker;
   CheckBox chk1,chk2,chk3;
   SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp = getSharedPreferences("user_data",MODE_PRIVATE);

        datepicker = findViewById(R.id.datePicker);
        timepicker = findViewById(R.id.timePicker);

        Calendar c = Calendar.getInstance();
        long date = c.getTime().getTime();

        datepicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MaterialDatePicker dp = MaterialDatePicker.Builder.datePicker().setSelection(date).build();
                dp.show(getSupportFragmentManager(),"tag1");
            }
        });

        int hour = c.get(Calendar.HOUR);
        int min = c.get(Calendar.MINUTE);


        timepicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MaterialTimePicker tp = new MaterialTimePicker.Builder().setHour(hour).setMinute(min).build();

                tp.show(getSupportFragmentManager(),"tag2");
            }
        });
    }
}