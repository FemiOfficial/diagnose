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
import android.widget.Toast;

import org.w3c.dom.Text;

public class ChangePinActivity extends AppCompatActivity implements View.OnClickListener {

    TextView txt_username, txt_password, txt_conpassword, txt_email;
    Button btn_register;
    MyDBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_pin);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        txt_username = (TextView) findViewById(R.id.text_username);
        txt_password = (TextView)findViewById(R.id.text_password);
        txt_conpassword = (TextView) findViewById(R.id.text_con_password);
        txt_email = (TextView) findViewById(R.id.text_email);
        btn_register = (Button) findViewById(R.id.btn_register);
        dbHandler = new MyDBHandler(this, null,null, 1);


        btn_register.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btn_register:
                signUp();
                break;
        }
    }
    public void signUp(){
        User user = new User(txt_username.getText().toString(), txt_email.getText().toString(),
                txt_password.getText().toString());
        if(txt_password.getText().toString().equals(txt_conpassword.getText().toString())){
            dbHandler.createUser(user);
            Toast.makeText(ChangePinActivity.this, "PIN Changed Successfully, Proceed to insert PIN" , Toast.LENGTH_LONG).show();
            Intent intent = new Intent();
            intent.setClass(this, LoginActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(ChangePinActivity.this, "PIN Entries Must Match" , Toast.LENGTH_LONG).show();
        }
        // Toast.makeText(RegisterActivity.this, "Registration Successfull" , Toast.LENGTH_LONG).show();

        //        test_printb.setText(printDB());
        //   System.out.println(printDB());
    }



}
