package com.oscar.career.viewimp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.timepicker.MaterialTimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
   Button datepicker;
   Button timepicker;
   CheckBox chk1,chk2,chk3;
   RadioButton rd1,rd2,rd3;
   SharedPreferences sp;
   Spinner spinner;
   ProgressBar progress;
   Button sbtn;
   int progressValue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp = getSharedPreferences("user_data",MODE_PRIVATE);

        datepicker = findViewById(R.id.datePicker);
        timepicker = findViewById(R.id.timePicker);
        chk1 = findViewById(R.id.chk1);
        chk2 = findViewById(R.id.chk2);
        chk3 = findViewById(R.id.chk3);
        rd1 = findViewById(R.id.rd1);
        rd2 = findViewById(R.id.rd2);
        rd3 = findViewById(R.id.rd3);
        spinner = findViewById(R.id.spinner);
        progress = findViewById(R.id.progress);
        sbtn = findViewById(R.id.sbtn);

        int lastSelcted = sp.getInt("key_11",0);
        spinner.setSelection(lastSelcted);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                sp.edit().putInt("key_11",position).commit();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        Calendar c = Calendar.getInstance();
        long date = c.getTime().getTime();

        boolean userdatachecked = sp.getBoolean("key_1",false);
        chk1.setChecked(userdatachecked);

        chk1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                sp.edit().putBoolean("key_1",true).commit();
            }
        });

        boolean userdatachecked1 = sp.getBoolean("key_2",false);
        chk2.setChecked(userdatachecked1);

        chk2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                sp.edit().putBoolean("key_2",true).commit();
            }
        });

        boolean userdatachecked2 = sp.getBoolean("key_3",false);
        chk2.setChecked(userdatachecked2);

        chk2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                sp.edit().putBoolean("key_3",true).commit();
            }
        });

        boolean userdatachecked3 = sp.getBoolean("key_4",false);
        rd1.setChecked(userdatachecked3);

        rd1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                sp.edit().putBoolean("key_4",true).commit();
            }
        });

        boolean userdatachecked4 = sp.getBoolean("key_5",false);
        rd2.setChecked(userdatachecked4);

        rd2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                sp.edit().putBoolean("key_5",true).commit();
            }
        });


        boolean userdatachecked5 = sp.getBoolean("key_6",false);
        rd3.setChecked(userdatachecked5);

        rd3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                sp.edit().putBoolean("key_6",true).commit();
            }
        });

        sbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(progressValue<=100){
                    progressValue++;
                    progress.setProgress(progressValue);
                }
            }
        });

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