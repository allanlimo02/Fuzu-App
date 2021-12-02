package com.moringaschool.fuzupayapp.Finance.Pazyroll.reviewApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ReviewApi {
    @GET("staffw/")
    Call<List<reviewResponse>> getStaffReviews();
}
