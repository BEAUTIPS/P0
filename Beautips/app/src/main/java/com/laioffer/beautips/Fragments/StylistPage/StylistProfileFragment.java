package com.laioffer.beautips.Fragments.StylistPage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.laioffer.beautips.R;
import com.laioffer.beautips.databinding.FragmentStylistProfileBinding;


public class StylistProfileFragment extends Fragment {


    public static ViewPager viewPager;
    private FragmentStylistProfileBinding binding;
    public static TabLayout tabLayout;
    private PostReviewTabAdapter adapter;



    public StylistProfileFragment() {
        // Required empty public constructor
    }

    /*
    When create, bind with xml file
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = binding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        // find all the other states
        // Not implement


        viewPager = binding.viewPager;
        viewPager.setOffscreenPageLimit(2);
        tabLayout = binding.tab;
        createTabFragment();

    }

    private void createTabFragment(){
        adapter = new PostReviewTabAdapter(getActivity().getSupportFragmentManager(), tabLayout);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }



    }
