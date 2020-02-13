package com.sgh000575.smartsociety;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvReg;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvReg = findViewById( R.id.register_tv );
        btnLogin = findViewById( R.id.login_btn );

        tvReg.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Intent i = new Intent(getApplicationContext(),Register.class);
                //startActivity( i );
            }
        } );

        btnLogin.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),DashboardActivity.class);
                startActivity( i );
            }
        } );

    }
}
