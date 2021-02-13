package com.laioffer.beautips.Fragments.startup;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.laioffer.beautips.Models.User;
import com.laioffer.beautips.Repository.UserRepository;


public class setUpViewModel extends ViewModel {

    private  UserRepository repo;
    public setUpViewModel(UserRepository repo){
        this.repo = repo;
    }
    public MutableLiveData<Boolean> getUserInfo(User user){
        MutableLiveData<Boolean> result = this.repo.getUserInfo(user);
        return result;
    }
}
