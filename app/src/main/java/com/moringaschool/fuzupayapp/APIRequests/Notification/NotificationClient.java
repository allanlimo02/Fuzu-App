package com.moringaschool.fuzupayapp.APIRequests.Notification;

import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NotificationClient {

    private static Retrofit getRetrofit(){


        Retrofit retrofits = new Retrofit.Builder()
                .baseUrl("https://machachari.herokuapp.com/finance/api/")
                .addConverterFactory(GsonConverterFactory.create())
//                .client()
                .build();
        return retrofits;

    }

    public static NotificationInterface getNotification(){
        NotificationInterface notificationInterface = getRetrofit().create(NotificationInterface.class);
        return  notificationInterface;
    }
}
