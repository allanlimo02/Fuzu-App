package com.moringaschool.fuzupayapp.APIRequests.FinancePayrolePaymentApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PayrolePaymentInterface {
    @GET("payw/")
    Call<List<PayrolePaymentResponse>> getAllpayments();
}
