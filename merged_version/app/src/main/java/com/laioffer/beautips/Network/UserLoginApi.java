package com.laioffer.beautips.Network;

import com.laioffer.beautips.Models.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface UserLoginApi {

    @Headers("Content-Type: applicationint/json")

    @POST("userlogininfos")
    Call<Boolean> getUserLoginInfo(@Body User user);


}
