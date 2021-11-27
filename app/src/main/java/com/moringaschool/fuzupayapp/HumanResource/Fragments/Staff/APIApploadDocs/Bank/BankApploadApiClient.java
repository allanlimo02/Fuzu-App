package com.moringaschool.fuzupayapp.HumanResource.Fragments.Staff.APIApploadDocs.Bank;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BankApploadApiClient {
    private static Retrofit getApploadRetrofit(){

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://fuzupay-hr.herokuapp.com/human-resource/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        return retrofit;
    }
    public static BankApploadUserService getService(){
        BankApploadUserService bankApploadUserService = getApploadRetrofit().create(BankApploadUserService.class);
        return bankApploadUserService;
    }
}
