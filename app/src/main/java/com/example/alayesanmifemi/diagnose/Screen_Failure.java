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

public class Screen_Failure extends AppCompatActivity {

    private ArrayList<QuestionItem> questionItems;
    private QuestionAdapter mAdapter;
    CardView cardView_message;
    TextView diagnosis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_failure);
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
                    if(click_message_name.equals("Computer screen turns white on startup")){
                        String message = "Solution 1: Run sfc/scannow command\n" +
                                "\t1. Right-click on Start Menu button and open Command Prompt (Admin).\n" +
                                "\t2. Enter the following line and press Enter: sfc/scannow.\n" +
                                "\t3. Wait until the scan is finished (since the scan is deep, it could last for a while).\n" +
                                "\t4. Restart your computer and see if white screen still appears.\n" +
                                "Solution 2: Connect your PC to a different display\n" +
                                "\t1. If you’re getting white computer screen on your laptop, the problem might be your graphics " +
                                "card or even your display. To check if your laptop is the problem, connect it to an external display " +
                                "and check if the issue reappears.\n" +
                                "\t2. If your graphics card is faulty, the white screen should appear on the external screen as well. " +
                                "If not, it means that the problem is caused by your laptop display. You can also apply this solution to" +
                                " the desktop PC and check if your monitor is faulty.\n" +
                                "Solution 3: Remove your laptop battery\n" +
                                "\t1. If you’re getting a white screen on your laptop, you might be able to fix the problem simply by removing your laptop battery. To see how to remove the battery, check your laptop’s instruction manual.\n" +
                                "\t2. Once you remove the battery, make sure that your laptop is disconnected from the power cord. Now press and hold the power button for 30 seconds or so. After doing that, insert the battery again, turn on your laptop and check if the problem still persists.\n" +
                                "Solution 4: Check your graphics card\n" +
                                "\t1. Sometimes white screen can appear if your graphics card is faulty. If the computer screen goes white as soon as you press the Power button, that’s a good indicator that something is wrong with your graphics card.\n" +
                                "\t2. Even if the problem appears as soon as Windows starts, the issue can be your graphics card, so you might want to consider replacement. Since new graphics card is costly, consider replacement only after trying all other solutions.\n";
                        diagnosis.setText(message);
                    }else if(click_message_name.equals("Discoloration and Distortion on Screen")){
                        String message = "1. Power off the monitor, wait 15 seconds and then power it back on. Some issues, especially very minor " +
                                "ones, can be caused by very temporary issues with the connection to your computer that a restart will fix.\n" +
                                "\t\tTip: If the problem goes away but quickly returns, especially if it's color related, try leaving the " +
                                "screen off for 30 minutes before powering it back on. If that helps, your monitor may be suffering from overheating.\n" +
                                "\t2. Restart your computer. There's a small chance that an operating system" +
                                " issue is the cause of the discoloration or distortion and a simple restart will do the trick." +
                                " This is such an easy thing to try, however, that doing it early in the troubleshooting is smart.\n" +
                                "\t3. Check the cable between the monitor and the computer to make sure that each end is physically " +
                                "secure. Completely unplug, and plug back in, each end just to be sure.\n" +
                                "\t4. If the above steps doesn't work, you may need to replace your monitor.";
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
        questionItems.add(new QuestionItem("Computer screen turns white on startup"));
        questionItems.add(new QuestionItem("Discoloration and Distortion on Screen"));
    }

}
