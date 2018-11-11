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

import java.util.ArrayList;

public class Power_Failure extends AppCompatActivity {
    private ArrayList<QuestionItem> questionItems;
    private QuestionAdapter mAdapter;
    CardView cardView_message;
    TextView diagnosis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_power__failure);
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
                    if(click_message_name.equals("The Computer Won’t Start")){
                        String message = "A computer that suddenly shuts off or has difficulty starting up could have a failing power supply\n" +
                                "\t\n" +
                                "\t1. Check that the computer is plugged into the power point properly\n" +
                                "\t2. If that doesn’t work, test the power point with another working device to confirm whether or not there is adequate power.\n" +
                                "If the problem is from the power outlet or the connecting cables, that should fix it.\n";
                        diagnosis.setText(message);
                    }else if(click_message_name.equals("Laptop battery not working")){
                        String message = "You may need to check that the battery is connected properly.\n" +
                                "\t\n" +
                                "\t1. Remove the battery and reattach with a bit of a hard shove in case there is an electrical contact problem. If this does not work, it might be that the battery has no charge. Either the battery is failing or the supply of electricity to the battery is failing.\n" +
                                "\t2. Take a look at the socket where the lead from the battery charger goes. If there is a thin pin in the socket, is it very wobbly. It is not uncommon for someone to trip on the battery charger lead and break the socket where the battery charger lead attaches.\n" +
                                "\t3. It is also possible that the battery charger has died. You can purchase a universal laptop charger and a new battery does not cost that much\n" +
                                "The above steps should help fix your laptop battery problem";
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
        questionItems.add(new QuestionItem("The Computer Won’t Start"));
        questionItems.add(new QuestionItem("Laptop battery not working"));
    }

}
