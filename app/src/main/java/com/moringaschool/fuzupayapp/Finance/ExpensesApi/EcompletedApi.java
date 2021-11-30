package com.moringaschool.fuzupayapp.Finance.ExpensesApi;

import com.moringaschool.fuzupayapp.HumanResource.onLeaveResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EcompletedApi {
    @GET("expensesw/")
    Call<List<EcompletedResponse>> getCompletedExpense();
}
