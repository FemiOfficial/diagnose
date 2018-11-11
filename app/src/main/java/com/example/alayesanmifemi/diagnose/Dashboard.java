package com.example.alayesanmifemi.diagnose;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class Dashboard extends AppCompatActivity implements View.OnClickListener {

    CardView boot_failure;
    CardView power_failure;
    CardView sound_failure;
    CardView screen_failure;
    CardView cd_failure;
    CardView printer_failure;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        boot_failure = (CardView)findViewById(R.id.boot_failure);
        power_failure = (CardView) findViewById(R.id.power_failure);
        sound_failure = (CardView) findViewById(R.id.sound_failure);
        screen_failure = (CardView)findViewById(R.id.screen_failure);
        cd_failure = (CardView)findViewById(R.id.cd_failure);
        printer_failure = (CardView)findViewById(R.id.printer_failure);
        cd_failure.setOnClickListener(this);
        printer_failure.setOnClickListener(this);
        screen_failure.setOnClickListener(this);
        sound_failure.setOnClickListener(this);
        power_failure.setOnClickListener(this);
        boot_failure.setOnClickListener(this);
    }

    public void onBackPressed(){
        AlertDialog.Builder builder = new AlertDialog.Builder(Dashboard.this);

        builder.setTitle("Log Out")
                .setMessage("Do you want to Logout?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Dashboard.super.onBackPressed();
                    }
                })
                .setNegativeButton("No", null).setCancelable(false);
        AlertDialog alert = builder.create();
        alert.show();
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.boot_failure:
                Intent intent1 = new Intent(this, Diagnosis.class);
                startActivity(intent1);
                break;
            case R.id.power_failure:
                Intent intent2 = new Intent(this, Power_Failure.class);
                startActivity(intent2);
                break;
            case R.id.sound_failure:
                Intent intent3 = new Intent(this, Sound_Failure.class);
                startActivity(intent3);
                break;
            case R.id.screen_failure:
                Intent intent4 = new Intent(this, Screen_Failure.class);
                startActivity(intent4);
                break;
            case R.id.cd_failure:
                Intent intent5 = new Intent(this, CD_Drive_Failure.class);
                startActivity(intent5);
                break;
            case R.id.printer_failure:
                Intent intent6 = new Intent(this, Printer_Failure.class);
                startActivity(intent6);
                break;
        }
    }
}
