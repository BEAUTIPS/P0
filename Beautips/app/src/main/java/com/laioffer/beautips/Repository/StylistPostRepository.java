package com.laioffer.beautips.Repository;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.laioffer.beautips.Models.Stylist;
import com.laioffer.beautips.Network.RetrofitClient;
import com.laioffer.beautips.Network.StylistProfileApi;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StylistPostRepository {

    private final StylistProfileApi StylistProfileApi;
    Stylist stylistInfo = null;

    public StylistPostRepository(Context context) {
        StylistProfileApi = RetrofitClient.newInstance(context).create(StylistProfileApi.class);

    }



}
