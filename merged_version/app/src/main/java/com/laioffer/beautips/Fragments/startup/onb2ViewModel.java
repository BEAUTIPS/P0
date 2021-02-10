package com.laioffer.beautips.Fragments.startup;

import android.content.Intent;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.laioffer.beautips.Models.User;
import com.laioffer.beautips.Repository.UserRepository;

public class onb2ViewModel extends ViewModel {
    private MutableLiveData<String> shape = new MutableLiveData<String>();
    private User user = new User();
    private UserRepository repository;
    Intent intent = new Intent();
    public onb2ViewModel(UserRepository repository) {
        this.repository = repository;
    }

    public onb2ViewModel() {

    }


    public MutableLiveData<String> getShape() {
        if (shape == null) {
            shape = new MutableLiveData<>();
        }
        return shape;
    }


    public void setShape(String inputshape) {
        if(inputshape == null){
            Log.d("shape", "user has not select his/her shape");
        }

        shape.setValue(inputshape);
        user.setBodyShape(inputshape);
        Log.d("shape", user.getBodyShape());
    }


}
