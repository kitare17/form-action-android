package com.example.eventhander;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

public class CalculateActivity extends AppCompatActivity implements View.OnClickListener {
     private Button btn;
     private CheckBox cb1,cb2;
     private RadioButton rb1,rb2;
     private RatingBar rbar;

     private EditText time, date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculate);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initView();

        Spinner spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                // Do something with the selected item
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do something when no item is selected
            }
        });



    }
    private void initView(){
        btn = findViewById(R.id.button1);
        cb1 = findViewById(R.id.checkBox1);
        cb2 = findViewById(R.id.checkBox2);
        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        rbar = findViewById(R.id.ratingBar);
        time=findViewById(R.id.editTextTime);
        date=findViewById(R.id.editTextDate);
        time.setOnClickListener(this);
        date.setOnClickListener(this);
    }
    public void calculate(View view) {
        Toast.makeText(this, "Calculate Clicked" +rb1.isChecked()+" "+rb2.isChecked()+" "+rbar.getRating()+" "+time.getText()+" "+date.getText(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
         if(view==time){
             Calendar calendar = Calendar.getInstance();
             int hour = calendar.get(Calendar.HOUR_OF_DAY);
             int minute = calendar.get(Calendar.MINUTE);
             TimePickerDialog timePickerDialog = new TimePickerDialog(CalculateActivity.this, new TimePickerDialog.OnTimeSetListener() {
                 @Override
                 public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
                     time.setText(hourOfDay + ":" + minute);
                 }
             }, hour, minute, true);
             timePickerDialog.show();
         }

         if(view==date) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(CalculateActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(android.widget.DatePicker datePicker, int year, int month, int day) {
                        date.setText(day + "/" + month + "/" + year);
                    }
                }, year, month, day);
                datePickerDialog.show();
         }
    }

}