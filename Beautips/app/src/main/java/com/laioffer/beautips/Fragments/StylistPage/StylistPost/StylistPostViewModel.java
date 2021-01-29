package com.laioffer.beautips.Fragments.StylistPage.StylistPost;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.laioffer.beautips.Models.Stylist;
import com.laioffer.beautips.Repository.StylistPostRepository;

import java.util.List;

public class StylistPostViewModel extends ViewModel {

    private final StylistPostRepository repo;

    public StylistPostViewModel(StylistPostRepository stylistRepo) {
        this.repo = stylistRepo;
    }


}
