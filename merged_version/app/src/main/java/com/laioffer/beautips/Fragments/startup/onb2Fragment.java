package com.laioffer.beautips.Fragments.startup;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.laioffer.beautips.R;


public class onb2Fragment extends Fragment implements View.OnClickListener{

    private ImageButton next;
    private ImageButton Hourglass;
    private ImageButton Round;
    private ImageButton Triangle;
    private ImageButton Rectangle;
    private ImageButton Pear;
    private TextView HourglassText ;
    private SharedPreferences preferences;
    private SharedPreferences.Editor myEdit;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        super.onCreateView(inflater, container,savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_onb2, null);
        preferences = getActivity().getSharedPreferences("loginSharedPreferences", Context.MODE_PRIVATE);
        myEdit = preferences.edit();
        initview(view);
        return view;
    }



    private void initview(View view) {
        HourglassText = view.findViewById(R.id.Hourglass);
       // HourglassText.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
        Hourglass = view.findViewById(R.id.Hourglass_pic);
        Round = view.findViewById(R.id.Round_pic);
        Triangle = view.findViewById(R.id.Triangle_pic);
        Rectangle = view.findViewById(R.id.Rectangle_pic);
        Pear = view.findViewById(R.id.Pear_pic);
        next = view.findViewById(R.id.next);
        Hourglass.setOnClickListener(this);
        Round.setOnClickListener(this);
        Triangle.setOnClickListener(this);
        Rectangle.setOnClickListener(this);
        Pear.setOnClickListener(this);
        next.setOnClickListener(this);

    }

        @Override
    public void onClick(View arg0) {

        switch (arg0.getId()) {
            case R.id.Hourglass_pic:
                myEdit.putString("shape","Hourglass").apply();
                break;
            case R.id.Round_pic:
                myEdit.putString("shape","Round").apply();
                break;
            case R.id.Triangle_pic:
                myEdit.putString("shape","Triangle").apply();
                break;
            case R.id.Rectangle_pic:
                myEdit.putString("shape","Rectangle").apply();
                break;
            case R.id.Pear_pic:
                myEdit.putString("shape","Pear").apply();
                break;
            case R.id.next:
                getFragmentManager().beginTransaction().replace(R.id.fl_main, new onb3Fragment()).commit();
                break;
            default:
                break;
        }
    }

}