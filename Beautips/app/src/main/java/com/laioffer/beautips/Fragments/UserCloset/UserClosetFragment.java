package com.laioffer.beautips.Fragments.UserCloset;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.laioffer.beautips.Fragments.StylistPage.PostReviewTabAdapter;
import com.laioffer.beautips.Fragments.UserCloset.MatchPost.MatchPostAdapter;
import com.laioffer.beautips.databinding.FragmentClosetBinding;
import com.laioffer.beautips.databinding.FragmentStylistProfileBinding;

public class UserClosetFragment extends Fragment {
    public static ViewPager viewPager;
    private FragmentClosetBinding binding;
    public static TabLayout tabLayout;
    private MatchPostAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = binding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        // find all the other states
        // Not implement


//        viewPager = binding.viewPager;
//        viewPager.setOffscreenPageLimit(2);
//        tabLayout = binding.tab;
//        createTabFragment();
    }

//    private void createTabFragment(){
//        adapter = new MatchPostAdapter(getActivity().getSupportFragmentManager(), tabLayout);
//        viewPager.setAdapter(adapter);
//        tabLayout.setupWithViewPager(viewPager);
//    }
}