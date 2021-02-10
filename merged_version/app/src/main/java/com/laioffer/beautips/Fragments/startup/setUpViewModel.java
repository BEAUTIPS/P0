package com.laioffer.beautips.Fragments.startup;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.laioffer.beautips.Models.User;
import com.laioffer.beautips.Repository.UserRepository;


public class setUpViewModel extends AndroidViewModel {

    private  UserRepository repo;
    private SharedPreferences preferences = getApplication().getSharedPreferences("loginSharedPreferences", Context.MODE_PRIVATE);
    private SharedPreferences.Editor myEdit;
    public User user;
    public setUpViewModel(Application application, UserRepository repo) {
        super(application);
        this.repo = repo;
    }


    public User setDefaultUser (){
        user = new User();
        user.setEmail(preferences.getString("email", ""));
        user.setName(preferences.getString("name",""));
        user.setPassword(preferences.getString("password",""));
        user.setBodyShape(preferences.getString("shape", ""));
        user.setAge(preferences.getInt("age", -1));
        user.setTopSize(preferences.getString("topSize", ""));
        user.setBottomSize(preferences.getString("bottomSize", ""));
        return user;
    }


    public MutableLiveData<Boolean> getUserInfo(){
        Log.d("test_node", "here in the info func");
        MutableLiveData<Boolean> result = this.repo.getUserInfo(this.setDefaultUser());
        return result;
    }







}
