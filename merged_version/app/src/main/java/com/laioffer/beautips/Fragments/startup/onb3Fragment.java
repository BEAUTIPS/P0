package com.laioffer.beautips.Fragments.startup;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import android.app.Fragment;

import com.laioffer.beautips.R;
import com.laioffer.beautips.databinding.FragmentOnb2Binding;

public class onb3Fragment extends Fragment implements View.OnClickListener{
    private SharedPreferences preferences;
    private SharedPreferences.Editor myEdit;
    private ImageButton next;
    private Button under_18;
    private Button between18_22;
    private Button between22_29;
    private Button between30_39;
    private Button moreThan_40;
    Context context;
    setUpViewModel viewModel;
    FragmentOnb2Binding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        binding = binding.inflate(inflater, container, false);
        View view = inflater.inflate(R.layout.fragment_onb3, null);
        preferences = getActivity().getSharedPreferences("loginSharedPreferences", Context.MODE_PRIVATE);
        myEdit = preferences.edit();
        initview(view);
        return view;
    }

    private void initview(View view) {
        under_18 = view.findViewById(R.id.under_18);
        between18_22 = view.findViewById(R.id.age_22);
        between22_29 = view.findViewById(R.id.age_29);
        between30_39 = view.findViewById(R.id.age_39);
        moreThan_40 = view.findViewById(R.id.age_40);
        next = view.findViewById(R.id.next);

        under_18.setOnClickListener(this);
        between18_22.setOnClickListener(this);
        between22_29.setOnClickListener(this);
        between30_39.setOnClickListener(this);
        moreThan_40.setOnClickListener(this);
        next.setOnClickListener(this);

    }

    @Override
    public void onClick(View arg0) {
        switch (arg0.getId()) {
            case R.id.under_18:
                myEdit.putString("age", "Under 18").apply();
                break;
            case R.id.age_22:
                myEdit.putString("age", "18-22").apply();
                break;
            case R.id.age_29:
                myEdit.putString("age", "22-29").apply();
                break;
            case R.id.age_39:
                myEdit.putString("age", "29-39").apply();
                break;
            case R.id.age_40:
                myEdit.putString("age", "40+").apply();
                break;
            case R.id.next:
                Fragment fragment = new onb4Fragment();
                getFragmentManager().beginTransaction().replace(R.id.fl_main, fragment).commit();
            default:
                break;
        }
    }

}