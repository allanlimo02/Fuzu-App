package com.moringaschool.fuzupayapp.HumanResource.Fragments.Leave.PostrequestApi;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostClient {
    private static Retrofit getretrof(){

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://fuzupay-hr.herokuapp.com/human-resource/api/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }

    public static PostleaveInterface getleaveservice(){
        PostleaveInterface postleaveInterface = getretrof().create(PostleaveInterface.class);
        return  postleaveInterface;
    }
}
