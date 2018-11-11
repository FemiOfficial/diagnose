package com.example.alayesanmifemi.diagnose;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Alayesanmi Femi on 30/08/2018.
 */

public class QuestionAdapter extends ArrayAdapter<QuestionItem> {


    public QuestionAdapter(Context context, ArrayList<QuestionItem> questionList){
        super(context, 0, questionList);

    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }
    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }
    private View initView(int position, View convertView, ViewGroup parent){
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.fault_message_spinner, parent, false
            );
        }
        TextView textViewname = convertView.findViewById(R.id.message_text);
        QuestionItem currentItem = getItem(position);
        textViewname.setText(currentItem.getmQuestionName());
        return convertView;
    }


}
