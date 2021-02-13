package com.laioffer.beautips.Fragments.startup;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.laioffer.beautips.R;

public class onb1Fragment extends Fragment implements View.OnClickListener {
    private ImageButton  start_now;
    private TextView login;
    private SharedPreferences preferences;
    private SharedPreferences.Editor myEdit;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        preferences = getActivity().getSharedPreferences("loginSharedPreferences", Context.MODE_PRIVATE);
        myEdit = preferences.edit();
        View view = inflater.inflate(R.layout.fragment_onb1, null);
        initview(view);
        return view;
    }

    private void initview(View view) {
        start_now = (ImageButton) view.findViewById(R.id.star_now);//重置按钮
        start_now.setOnClickListener(this);
        login=(TextView)view.findViewById(R.id.login_1);
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View arg0) {
        switch (arg0.getId()) {
            case R.id.star_now:
                getFragmentManager().beginTransaction().replace(R.id.fl_main, new onb2Fragment()).commit();
                break;
            case R.id.login_1:
                myEdit.putString("location", "onb1").apply();
                getFragmentManager().beginTransaction().replace(R.id.fl_main, new logInFragment()).commit();
                break;
            default:
                break;
        }
    }


}