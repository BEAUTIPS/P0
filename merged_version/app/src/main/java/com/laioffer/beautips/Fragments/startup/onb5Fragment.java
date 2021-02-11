package com.laioffer.beautips.Fragments.startup;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.app.Fragment;

import com.laioffer.beautips.R;

public class onb5Fragment extends Fragment implements View.OnClickListener {
    private SharedPreferences preferences;
    private SharedPreferences.Editor myEdit;
    private TextView shape;
    private TextView age;
    private TextView top_size;
    private TextView bottom_size;
    private ImageButton sign_up;
    private TextView see_tips;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container,savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_onb5, null);
        preferences = getActivity().getSharedPreferences("loginSharedPreferences", Context.MODE_PRIVATE);
        myEdit = preferences.edit();
        initview(view);
        return view;
    }


    private void initview(View view) {
        shape = view.findViewById(R.id.shape);
        age = view.findViewById(R.id.age);
        top_size = view.findViewById(R.id.top_size);
        bottom_size = view.findViewById(R.id.bottom_size);
        sign_up = view.findViewById(R.id.sign_up);
        see_tips = view.findViewById(R.id.see_style_tips);

        shape.setText(preferences.getString("shape","") + " Shape");
        age.setText("Age " + preferences.getString("age", ""));
        top_size.setText("Top " + preferences.getString("topSize","") + " Size");
        bottom_size.setText("Top " + preferences.getString("bottomSize",  "")+ " Size");
        sign_up.setOnClickListener(this);
    }

    @Override
    public void onClick(View arg0) {
        switch (arg0.getId()) {
            case R.id.sign_up:
                Fragment fragment = new signUpFragment();
                getFragmentManager().beginTransaction().replace(R.id.fl_main, fragment).commit();
                break;
            case R.id.see_style_tips:
                 fragment = new signUpFragment();
                getFragmentManager().beginTransaction().replace(R.id.fl_main, fragment).commit();
                break;
            default:
                break;
        }


    }
}