package com.moringaschool.fuzupayapp.HumanResource.LeaveApi;


import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class onLeaveClient {
    private static Retrofit getRetrofit(){

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://fuzupay-hr.herokuapp.com/human-resource/api/leaves/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

                return retrofit;
    }
    public static OnLeaveApi getUserServices(){
        OnLeaveApi userService = getRetrofit().create(OnLeaveApi.class);

        return userService;
    }
}
