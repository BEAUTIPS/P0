package com.laioffer.beautips.Fragments.startup;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.app.Fragment;
import com.laioffer.beautips.R;
import com.laioffer.beautips.databinding.FragmentOnb1Binding;
import com.laioffer.beautips.databinding.FragmentOnb2Binding;

public class onb1Fragment extends Fragment implements View.OnClickListener {
    FragmentOnb1Binding binding;
    private ImageButton  start_now;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        super.onCreateView(inflater, container,savedInstanceState);
        binding = binding.inflate(inflater, container, false);
        //View view = inflater.inflate(R.layout.fragment_onb1, container,true);
        //initview(view);
        return binding.getRoot();
    }

    @Override
    public void onClick(View v) {

    }
/*
    private void initview(View view) {
        start_now = (ImageButton) view.findViewById(R.id.star_now);//重置按钮

        start_now.setOnClickListener(this);
    }

    @Override
    public void onClick(View arg0) {
        switch (arg0.getId()) {
            case R.id.star_now:
                Fragment fragment = new onb2Fragment();
                getFragmentManager().beginTransaction().replace(R.id.fl_main, fragment).commit();
                break;
            default:
                break;
        }
    }
*/

}