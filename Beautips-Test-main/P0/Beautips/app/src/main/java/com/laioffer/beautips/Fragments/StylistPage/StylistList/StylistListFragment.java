package com.laioffer.beautips.Fragments.StylistPage.StylistList;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.laioffer.beautips.Fragments.StylistPage.StylistPost.StylistPostViewModel;
import com.laioffer.beautips.Models.Post;
import com.laioffer.beautips.Models.Stylist;
import com.laioffer.beautips.R;
import com.laioffer.beautips.Repository.BeautipsViewModelFactory;
import com.laioffer.beautips.Repository.StylistPostRepository;
import com.laioffer.beautips.databinding.FragmentStylistListBinding;
import com.laioffer.beautips.databinding.SingleStylistListBinding;

import java.util.ArrayList;
import java.util.List;

public class StylistListFragment extends Fragment {
    Context context;
    private FragmentStylistListBinding binding;


    RecyclerView recyclerView;

    ArrayList<Stylist> stylistList = new ArrayList<>();

    StylistPostViewModel stylistViewModel;


    // construct a view
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = binding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    // setup parameter
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.context = getContext();

        Log.d("a",binding.stylistListRecyclerView.toString());
        stylistList.add(new Stylist("abby"));

        StylistListAdapter stylistListAdapter = new StylistListAdapter(context, stylistList);
        binding.stylistListRecyclerView.setAdapter(stylistListAdapter);
        binding.stylistListRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));



        stylistListAdapter.setItemCallback(new StylistListAdapter.ItemCallback() {
            @Override
            public void onOpenDetails(Stylist stylistList) {
                Log.d("onOpenDetails", stylistList.toString());
//                StylistListFragmentDirections.ActionNavigationSaveToNavigationDetails direction;
//                direction = StylistListFragmentDirections.actionNavigationSaveToNavigationDetails(stylistList);
//                NavHostFragment.findNavController(StylistListFragment.this).navigate(direction);
            }
        });


//        StylistPostRepository repository = new StylistPostRepository(getContext());
//        stylistViewModel = new ViewModelProvider(this, new BeautipsViewModelFactory(repository))
//                .get(StylistPostViewModel.class);




    }
}
