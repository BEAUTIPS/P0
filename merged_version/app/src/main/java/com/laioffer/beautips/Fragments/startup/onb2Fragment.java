package com.laioffer.beautips.Fragments.startup;

import android.annotation.SuppressLint;
import android.app.FragmentManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.laioffer.beautips.Fragments.StylistPage.StylistPost.StylistPostAdapter;
import com.laioffer.beautips.Fragments.StylistPage.StylistPost.StylistPostViewModel;
import com.laioffer.beautips.Fragments.StylistPage.StylistProfileFragment;
import com.laioffer.beautips.Models.Post;
import com.laioffer.beautips.R;
import com.laioffer.beautips.databinding.FragmentOnb2Binding;
import com.laioffer.beautips.databinding.ScrollStylistPostsBinding;

import java.util.List;


public class onb2Fragment extends Fragment {

    private ImageButton next;
    private ImageButton Hourglass;
    private ImageButton Round;
    private ImageButton Triangle;
    private ImageButton Rectangle;
    private ImageButton Pear;
    private TextView HourglassText ;
    private SharedPreferences preferences;
    private SharedPreferences.Editor myEdit;
    Context context;
    setUpViewModel viewModel;
    FragmentOnb2Binding binding;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        super.onCreateView(inflater, container,savedInstanceState);
        binding = binding.inflate(inflater, container, false);
        //View view = inflater.inflate(R.layout.fragment_onb2, null);
        preferences = getActivity().getSharedPreferences("loginSharedPreferences", Context.MODE_PRIVATE);
        myEdit = preferences.edit();
        return binding.getRoot();
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        HourglassText = (TextView)binding.Hourglass;
        Hourglass = (ImageButton)binding.HourglassPic;
        Hourglass.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                FragmentManager fm = getActivity().getFragmentManager();
                Fragment fragment = new onb3Fragment();
                fm.beginTransaction()
                        .replace(R.id.fl_main, fragment)
                        .commit();
            }
        });

        Round = view.findViewById(R.id.Round_pic);

        Triangle = view.findViewById(R.id.Triangle_pic);
        Rectangle = view.findViewById(R.id.Rectangle_pic);
        Pear = view.findViewById(R.id.Pear_pic);
        next = view.findViewById(R.id.next);

    }










/*
        @Override
    public void onClick(View arg0) {

        switch (arg0.getId()) {
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
                Fragment fragment = new onb3Fragment();
                getFragmentManager().beginTransaction().replace(R.id.fl_main, fragment).commit();
                break;
            default:
                break;
        }
    }
*/
}