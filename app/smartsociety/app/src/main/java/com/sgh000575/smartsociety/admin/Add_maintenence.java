package com.sgh000575.smartsociety.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.DatePicker;

import com.sgh000575.smartsociety.R;

import java.util.Calendar;

public class Add_maintenence extends AppCompatActivity {

    DatePicker maintencence_date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_add_maintenence );

        maintencence_date =  findViewById( R.id.maintencence_date );

        Calendar c = Calendar.getInstance();

        maintencence_date.setMinDate( c.getTimeInMillis()-1000 );
    }
}
