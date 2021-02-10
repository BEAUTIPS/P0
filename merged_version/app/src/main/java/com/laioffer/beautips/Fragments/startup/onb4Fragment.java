package com.laioffer.beautips.Fragments.startup;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;

import com.laioffer.beautips.R;

public class onb4Fragment extends Fragment implements View.OnClickListener{
    private SharedPreferences preferences;
    private SharedPreferences.Editor myEdit;
    private Button top_XS;
    private Button top_S;
    private Button top_M;
    private Button top_L;
    private Button top_XL;
    private Button top_2XL;
    private Button top_3XL;
    private Button top_3XLL; // This is 3XL+
    private Button bottom_XS;
    private Button bottom_S;
    private Button bottom_M;
    private Button bottom_L;
    private Button bottom_XL;
    private Button bottom_2XL;
    private Button bottom_3XL;
    private Button bottom_3XLL; // This is 3XL+
    private ImageButton next;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_onb4, null);
        initview(view);
        preferences = getActivity().getSharedPreferences("loginSharedPreferences", Context.MODE_PRIVATE);
        myEdit = preferences.edit();
        return view;
    }

    private void initview(View view) {
        top_XS = view.findViewById(R.id.XS);
        top_S = view.findViewById(R.id.S);
        top_M = view.findViewById(R.id.M);
        top_L = view.findViewById(R.id.L);
        top_XL = view.findViewById(R.id.XL);
        top_2XL = view.findViewById(R.id.XL2);
        top_3XL = view.findViewById(R.id.XL3);
        top_3XLL = view.findViewById(R.id.XLL3);

        top_XS.setOnClickListener(this);
        top_S.setOnClickListener(this);
        top_M.setOnClickListener(this);
        top_L.setOnClickListener(this);
        top_XL.setOnClickListener(this);
        top_2XL.setOnClickListener(this);
        top_3XLL.setOnClickListener(this);


        bottom_XS = view.findViewById(R.id.b_XS);
        bottom_S = view.findViewById(R.id.b_S);
        bottom_M = view.findViewById(R.id.b_M);
        bottom_L = view.findViewById(R.id.b_L);
        bottom_XL = view.findViewById(R.id.b_XL);
        bottom_2XL = view.findViewById(R.id.b_XL2);
        bottom_3XL = view.findViewById(R.id.b_XL3);
        bottom_3XLL = view.findViewById(R.id.b_XLL3);


        bottom_XS.setOnClickListener(this);
        bottom_S.setOnClickListener(this);
        bottom_M.setOnClickListener(this);
        bottom_L.setOnClickListener(this);
        bottom_XL.setOnClickListener(this);
        bottom_2XL.setOnClickListener(this);
        bottom_3XLL.setOnClickListener(this);

        next = (ImageButton) view.findViewById(R.id.next);//重置按钮
        next.setOnClickListener(this);
    }

    @Override
    public void onClick(View arg0) {
        switch (arg0.getId()) {
            case R.id.XS:
                myEdit.putString("topSize","XS").apply();
                break;
            case R.id.S:
                myEdit.putString("topSize","S").apply();
                break;
            case R.id.M:
                myEdit.putString("topSize","M").apply();
                break;
            case R.id.L:
                myEdit.putString("topSize","L").apply();
                break;
            case R.id.XL:
                myEdit.putString("topSize","XL").apply();
                break;
            case R.id.XL2:
                myEdit.putString("topSize","2XL").apply();
                break;
            case R.id.XL3:
                myEdit.putString("topSize","3XL").apply();
                break;
            case R.id.XLL3:
                myEdit.putString("topSize","3XL+").apply();
                break;
            case R.id.next:
                getFragmentManager().beginTransaction().replace(R.id.fl_main, new onb5Fragment()).commit();
                break;
            case R.id.b_XS:
                myEdit.putString("bottomSize","XS").apply();
                break;
            case R.id.b_S:
                myEdit.putString("bottomSize","S").apply();
                break;
            case R.id.b_M:
                myEdit.putString("bottomSize","M").apply();
                break;
            case R.id.b_L:
                myEdit.putString("bottomSize","L").apply();
                break;
            case R.id.b_XL:
                myEdit.putString("bottomSize","XL").apply();
                break;
            case R.id.b_XL2:
                myEdit.putString("bottomSize","2XL").apply();
                break;
            case R.id.b_XL3:
                myEdit.putString("bottomSize","3XL").apply();
                break;
            case R.id.b_XLL3:
                myEdit.putString("bottomSize","3XL+").apply();
                break;
            default:
                break;
        }


    }

}