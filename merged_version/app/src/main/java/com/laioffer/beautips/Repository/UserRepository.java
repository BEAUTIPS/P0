package com.laioffer.beautips.Repository;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.laioffer.beautips.Fragments.startup.setUpViewModel;
import com.laioffer.beautips.Models.User;
import com.laioffer.beautips.Network.RetrofitClient;
import com.laioffer.beautips.Network.UserLoginApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {

    private final UserLoginApi userLoginApi;

    public UserRepository(Context context) {
        this.userLoginApi =  RetrofitClient.newInstance(context).create(UserLoginApi.class);
    }


    public MutableLiveData<Boolean> getUserInfo(User user){
        final MutableLiveData<Boolean> result = new MutableLiveData<>();
        Log.i("test", user.toString());
        Call<Boolean> callResult = userLoginApi.getUserLoginInfo(user);
        callResult.enqueue(new Callback<Boolean>() {
            @SuppressLint("LongLogTag")
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                if (response.isSuccessful()) {
                    result.setValue(response.body());
                    Log.i("Successful", response.body().toString());
                } else {
                    Log.i("Failure status code:", String.valueOf(response.errorBody()));
                    result.setValue(null);
                }
            }
            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {
                Log.i("Login is wrong", t.toString());
            }
        });
        result.setValue(true);
        return result;
    }












}
