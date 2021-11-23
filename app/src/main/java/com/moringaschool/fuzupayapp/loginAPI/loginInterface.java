package com.moringaschool.fuzupayapp.loginAPI;

import com.moringaschool.fuzupayapp.loginAPI.models.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface loginInterface {
    @POST("account/login/")
    Call<LoginResponse> loginUser(@Body loginRequest loginRequest);
}
