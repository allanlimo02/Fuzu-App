package com.moringaschool.fuzupayapp.APIRequests;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PayrollService {
    @GET("payw/")
    Call<List<PayrollResponse>> getAllPayrolls();
}
