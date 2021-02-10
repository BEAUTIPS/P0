package com.laioffer.beautips.Fragments.startup;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;

import com.laioffer.beautips.R;

public class onb1Fragment extends Fragment implements View.OnClickListener {

    private ImageButton  start_now;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_onb1, null);
        initview(view);
        return view;
    }

    private void initview(View view) {
        start_now = (ImageButton) view.findViewById(R.id.star_now);//重置按钮

        start_now.setOnClickListener(this);
    }

    @Override
    public void onClick(View arg0) {
        switch (arg0.getId()) {
            case R.id.star_now:
                getFragmentManager().beginTransaction().replace(R.id.fl_main, new onb2Fragment()).commit();
                break;
            default:
                break;
        }
    }


}