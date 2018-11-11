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

public class CD_Drive_Failure extends AppCompatActivity {

    private ArrayList<QuestionItem> questionItems;
    private QuestionAdapter mAdapter;
    CardView cardView_message;
    TextView diagnosis;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cd_drive_failure);
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
                    if(click_message_name.equals("Drive won't open or eject")){
                        String message = "Solution 1: Force eject from within the OS\n" +
                                "\t    1. Open File Explorer if you're using Windows 10 or Windows 8. Search for it or use the WIN+X menu to open it quickly.\n" +
                                "\t    2. Once open, navigate to the optical drive from the menu on the left. This drive is often auto-named based" +
                                " on what disc is inside the drive but there's usually a small disc icon to help identify it.\n" +
                                "\t    3. Right-click or tap-and-hold on the optical drive and choose Eject from the menu that pops up or down.\n" +
                                "\t    4. The drive bay or disc should spin down and eject within seconds.\n" +
                                "Solution 2: Open the drive with a pin\n" +
                                "\t    1. Look closely at your disc drive. Directly under or above the drive bay door (the part that \"ejects\" the disc), there should be a very small pinhole.\n" +
                                "            2. Insert the pin into the pinhole. Inside the drive, directly behind the pinhole, is a small gear that, when rotated, will begin to manually open the drive.\n" +
                                "\t    3. Remove and reinsert the paper clip as often as needed to eject the drive bay enough to grab hold of it.\n" +
                                "\t    4. Slowly pull into the drive bay until it's fully retracted. Take care not to pull too quickly or to continue to pull when you feel resistance.\n" +
                                "\t    5. Remove the CD or DVD from the drive. Slowly push the drive bay back into the drive until closed or press the open/close button if the drive is still working.\n";
                        diagnosis.setText(message);
                    }else if(click_message_name.equals("My drive will not read anything")){
                        String message = "1. Open the DVD rom bay on your laptop.\n" +
                                "\t2. Very carefully remove any dust or debris from the area around the laser head with a cue tip or gentle microfibre" +
                                " cloth, like the type used for cleaning monitors or lenses. BE GENTLE!" +
                                " You scratch that lense you are buying a whole new DVD drive.\n" +
                                "\t3. Once the area is clean, use a small, blunt object like a paperclip or " +
                                "plastic pen tip to gently, but firmly move the transport away from the centre spindle " +
                                "toward the outside. Clean up and more dirt or debris using the method above. If you have anything " +
                                "sticky or gooey, like ciagrette smoke or the like, you can use a mixture of 50% rubbing alcohol and distilled water on the q-tip to help remove junk.\n" +
                                "\t4. once clean and the transport is moved to the outer limit, place in a dvd and close the tray." +
                                " next time you boot your computer, the DVD reader will seek the correct centre ring on the DVD, and will then read it properly. The DVD will auto align, and your troubles should be over. If it happens again, you will know what to do.\n" +
                                "The culprit is a weak transport that can get stuck on smoke, dust, hair, or even get jammed in the centre if the unit takes a shock or too much vibration. Thankfully, it is a dead simple fix.";
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
        questionItems.add(new QuestionItem("Drive won't open or eject"));
        questionItems.add(new QuestionItem("My drive will not read anything"));
    }

}
