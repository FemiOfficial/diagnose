package com.example.alayesanmifemi.diagnose;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    TextView pin_text, text_change;
    MyDBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Button btn_login = (Button) findViewById(R.id.btn_login);
        pin_text = (TextView) findViewById(R.id.text_id);
        text_change = (TextView)findViewById(R.id.text_change);
        dbHandler = new MyDBHandler(this, null,null, 1);


        btn_login.setOnClickListener(this);
        text_change.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_login:
                String pin = pin_text.getText().toString();
            if(pin.equals("123456") ){
                Intent intent = new Intent(this, Dashboard.class);
                startActivity(intent);
            }else {
                if(verifyFromSQLite() == true){
                    Intent intent = new Intent(this, Dashboard.class);
                    startActivity(intent);
                }else{
                    Snackbar.make(view, "Invalid PIN, try Default PIN or Change PIN", Snackbar.LENGTH_LONG).show();
                }
            }
            break;
            case R.id.text_change:
                Intent intent1 = new Intent(this, ChangePinActivity.class);
                startActivity(intent1);
                break;
        }
    }
    private boolean verifyFromSQLite(){
        if(dbHandler.checkUser(pin_text
                .getText().toString().trim())){
            return true;
        }else{
            return false;
        }
    }
}
