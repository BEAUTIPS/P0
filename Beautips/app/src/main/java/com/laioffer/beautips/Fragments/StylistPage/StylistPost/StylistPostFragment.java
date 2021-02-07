package com.laioffer.beautips.Fragments.StylistPage.StylistPost;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.laioffer.beautips.Fragments.StylistPage.PostReviewTabAdapter;
import com.laioffer.beautips.Models.Post;
import com.laioffer.beautips.R;

import com.laioffer.beautips.databinding.ScrollStylistPostsBinding;
import com.laioffer.beautips.databinding.StylistPostBinding;

import java.util.ArrayList;

public class StylistPostFragment extends Fragment {



    Context context;
    RecyclerView recyclerView;
    StylistPostAdapter StylistPostAdapter;



    private ArrayList<com.laioffer.beautips.Models.Post> postList = new ArrayList<>();


    public StylistPostFragment() {
        // Required empty public constructor
    }



    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.context = getContext();
        recyclerView = view.findViewById(R.id.swipe_post_recycler_view);
        testlocalData();
        //use grid layout
        int numberOfColumns = 2;
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), numberOfColumns));
        StylistPostAdapter = new StylistPostAdapter(context, postList);
        recyclerView.setAdapter(StylistPostAdapter);


    }

    public void testlocalData(){
        for (char i = '1' ; i < '9' ; i++){
            String name = "" +'p' + i;
            postList.add(new Post(name));
        }


    }

}