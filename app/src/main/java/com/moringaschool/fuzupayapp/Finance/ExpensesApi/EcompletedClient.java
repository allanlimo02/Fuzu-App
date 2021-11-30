package com.moringaschool.fuzupayapp.Finance.ExpensesApi;

import com.moringaschool.fuzupayapp.HumanResource.LeaveApi.OnLeaveApi;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EcompletedClient {
    private static Retrofit getRetrofit(){

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://machachari.herokuapp.com/finance/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        return retrofit;
    }
    public static EcompletedApi getCompletedService(){
        EcompletedApi userService = getRetrofit().create(EcompletedApi.class);

        return userService;
    }
}
