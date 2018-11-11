package com.example.alayesanmifemi.diagnose;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Diagnosis extends AppCompatActivity {

    private ArrayList<QuestionItem> questionItems;
    private QuestionAdapter mAdapter;
    CardView cardView_message;
    TextView diagnosis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnosis);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initList();
        cardView_message = (CardView)findViewById(R.id.cardview_message);
        diagnosis = (TextView) findViewById(R.id.diagnosis);

        Spinner spinner_messages = findViewById(R.id.spinner_message);
        mAdapter = new QuestionAdapter(this, questionItems);
        spinner_messages.setAdapter(mAdapter);

        spinner_messages.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                QuestionItem clicked_question = (QuestionItem) adapterView.getItemAtPosition(i);
                String click_message_name = clicked_question.getmQuestionName();
                if(click_message_name.equals("Select Category")){
                    Snackbar.make(view, "Please Select Category", Snackbar.LENGTH_LONG).show();
                    cardView_message.setVisibility(View.INVISIBLE);
                }else{
                    cardView_message.setVisibility(View.VISIBLE);
                    if(click_message_name.equals("Computer takes loger time to start")){
                        String message = "The more items that the system has to load, the longer time it takes to load them.\n" +
                                "You can solve this problem by removing useless programs from the startup menu using msconfig.\n\n" +
                                "\t1.  Press Windows + R keys combination to open Run panel and type msconfig there.\n" +
                                "\n\n\t2.  Go to the Startup tab and uncheck all the programs that you don’t need at the startup.\n" +
                                "\n\n\t3.  When you are done, restart your computer system.\n\n" +
                                "Following the above steps helps to boost your computer startup speed.\n";
                        diagnosis.setText(message);
                    }else if(click_message_name.equals("Disk boot failure error on start up")){
                        String message = "As part of the boot process the BIOS tries to find a bootable drive to continue the loading process by starting its first sector everytime you start up your computer. \n" +
                                "If BIOS is unable to find a drive to boot from, then a Disk Boot Failure error screen is displayed and the boot process is halted.\n\nMethod 1: Change BIOS boot order\n" +
                                "\t  To check a computer’s boot order, follow these instructions:\n" +
                                "\t1. Restart the computer\n" +
                                "\t2. Open the BIOS. If you’re not sure which key is used to open BIOS, it’s either any of the following or it’s listed on the first screen that appears on the monitor, before the Windows logo appears.Possible keys: Esc, Del, F2, F8, F10 or F12\n" +
                                "\t3. Go to the Boot tab\n" +
                                "\t4. Change the order to position the hard disk as the 1st option\n" +
                                "\t5. Save these settings\n" +
                                "\t6. Restart the computer\n" +
                                "Method 2: Remove newly installed hardware, check data cables and jumpers\n" +
                                "\t  If a new hardware was recently added , follow these tips:\n" +
                                "\t\n" +
                                "\t1. Remove the newly added hardware and restart the computer to check if the error still appears\n" +
                                "\t2. Check the cables of the hard disk where Windows is installed\n" +
                                "\t3. Check the jumpers of the hard disk\n" +
                                "The above procedures should get you back up and running.\n";
                        diagnosis.setText(message);

                    }else{

                    }

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
    private void initList(){
        questionItems = new ArrayList<>();
        questionItems.add(new QuestionItem("Select Category"));
        questionItems.add(new QuestionItem("Computer takes loger time to start"));
        questionItems.add(new QuestionItem("Disk boot failure error on start up"));
    }

}
