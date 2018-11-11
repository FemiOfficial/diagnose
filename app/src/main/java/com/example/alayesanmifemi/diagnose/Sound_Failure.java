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

public class Sound_Failure extends AppCompatActivity {
    private ArrayList<QuestionItem> questionItems;
    private QuestionAdapter mAdapter;
    CardView cardView_message;
    TextView diagnosis;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound_failure);
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
                    if(click_message_name.equals("No Sound")){
                        String message = "1. First make sure that your speakers are plugged in correctly and the power/volume is on.\n" +
                                "\t2. If you have the sound icon in the tray, make sure it is not muted.\n" +
                                "\t3. Go to your computer manufacturer's website, find drivers and downloads and install the audio drivers for your computer\n" +
                                "\t4. Reboot and see if your sound works\n";
                        diagnosis.setText(message);
                    }else if(click_message_name.equals("Scratchy Sound")){
                        String message = "Distorted or scratchy audio can be caused by several problems. Improving the audio can be as simple as rearranging your hardware components.\n" +
                                "See if any of these situations apply, and take the recommended action to improve audio:\n" +
                                "\n" +
                                "\t1. Are there any other devices around the speakers or wires for the speakers? Electromagnetic interference can cause poor audio. Try moving your speakers and wires around and away from other devices.\n" +
                                "\t2. Have you recently added any cards to your computer? Cards in the computer can cause electromagnetic interference. Try moving the card to another location in the computer, if possible.\n" +
                                "\t3. Are your speakers too close to your monitor? The speakers can pick up electrical noise from your monitor, so move them farther away. Never place subwoofers near the monitor, because their powerful magnets can interfere with the picture. Place subwoofers on the floor to maximize low-frequency transmission.\n" +
                                "\t4. Check to see if you are having a hardware issue. Try another pair of computer speakers to see if that resolves the problem.\n" +
                                "\t5. Poor audio quality or low volumes can occur if you are using passive (nonamplified) speakers. Use amplified speakers.\n" +
                                "\t6. If you notice stuttering voices and static on some games or programs but not others, check with the software vendor for a software patch.";
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
        questionItems.add(new QuestionItem("No Sound"));
        questionItems.add(new QuestionItem("Scratchy Sound"));
    }

}
