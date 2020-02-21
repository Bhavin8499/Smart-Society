package com.sgh000575.smartsociety.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.DatePicker;

import com.sgh000575.smartsociety.R;

import java.util.Calendar;

public class Add_event extends AppCompatActivity {

    DatePicker event_date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_add_event );

        Calendar c = Calendar.getInstance();

        event_date =  findViewById( R.id.event_date );


        event_date.setMinDate( c.getTimeInMillis()-1000 );
    }
}
