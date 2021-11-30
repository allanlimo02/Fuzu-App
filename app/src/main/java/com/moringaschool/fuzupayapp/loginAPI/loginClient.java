package com.moringaschool.fuzupayapp.loginAPI;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class loginClient {

    public static Retrofit getRetrofit(){

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();



        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://machachari.herokuapp.com/")
                .client(okHttpClient)
                .build();
        return retrofit;
    }

    public static loginInterface getService(){
       loginInterface loginInterface = getRetrofit().create(com.moringaschool.fuzupayapp.loginAPI.loginInterface.class);
        return loginInterface;
    }
}
