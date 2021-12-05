package com.moringaschool.fuzupayapp.APIRequests.FinancePayrolePaymentApi;



import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PayrolePaymentClient {
    private static Retrofit getRetrofit(){

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Retrofit retrofits = new Retrofit.Builder()
                .baseUrl("https://machachari.herokuapp.com/finance/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
        return retrofits;

    }

    public static PayrolePaymentInterface getPayStatus(){
        PayrolePaymentInterface payrolePaymentInterface = getRetrofit().create(PayrolePaymentInterface.class);
        return  payrolePaymentInterface;
    }
}
