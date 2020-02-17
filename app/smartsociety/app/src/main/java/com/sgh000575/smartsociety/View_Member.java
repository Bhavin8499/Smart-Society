package com.sgh000575.smartsociety;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class View_Member extends AppCompatActivity {

    TextView member_name,member_gender,member_dob;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_view__member );

        member_name = findViewById( R.id.view_pro_name );
        member_gender = findViewById( R.id.view_profile_gen );
        member_dob = findViewById( R.id.view_profile_bdate );

        Intent i = getIntent();

        member_name.setText( i.getStringExtra( "mem_name" ));
        member_gender.setText( i.getStringExtra( "mem_gen" ));
        member_dob.setText( i.getStringExtra( "mem_dob" ));

    }
}
