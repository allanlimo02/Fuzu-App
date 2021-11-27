package com.moringaschool.fuzupayapp.HumanResource.Fragments.Leave.RequestAPI;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RequestInterface {

    @GET("leaves")
    Call<List<RequestResponse>> getAllRequests();

}
