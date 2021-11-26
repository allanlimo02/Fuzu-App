package com.moringaschool.fuzupayapp.APIRequests.StaffApiResources;

import androidx.annotation.NonNull;

import com.moringaschool.fuzupayapp.loginAPI.models.User;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.HttpException;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class StaffClientClass {
//    private  static OkHttpClient okHttpClient;
//    private static Retrofit retrofit = null;
//    public static StaffInterface getClient() {

//        if (retrofit == null) {
//            OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                    .addInterceptor(new Interceptor() {
//                        @NonNull
//                        @Override
//                        public Response intercept(@NonNull Chain chain) throws IOException {
//                            Request newRequest = chain
//                                    .request()
//                                    .newBuilder()
//                                    .build();
//                            return chain.proceed(newRequest);
//                        }
//                    }).build();
//        }
//        retrofit = new Retrofit.Builder()
//                .baseUrl(StaffConstants.getEmployeesUrl)
//                .client(okHttpClient)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        return retrofit.create(StaffInterface.class);
//        return retrofit;
//    }



    private  static Retrofit getRetrofit(){
        HttpLoggingInterceptor httpLoggingInterceptor= new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient= new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();


        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://fuzupay-hr.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
        return retrofit;
    }
    public  static  StaffInterface staffInterface (){
        StaffInterface staffInterface=getRetrofit().create(StaffInterface.class);
        return  staffInterface;
    }

}