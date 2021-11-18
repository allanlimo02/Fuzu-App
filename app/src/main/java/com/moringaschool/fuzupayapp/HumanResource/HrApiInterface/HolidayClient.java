package com.moringaschool.fuzupayapp.HumanResource.HrApiInterface;

//import static com.moringaschool.fuzupayapp.BuildConfig.api_key;
//import static com.moringaschool.fuzupayapp.HolidayConstants.HOLIDAY_API_KEY;
import static com.moringaschool.fuzupayapp.BuildConfig.API_KEY;
import static com.moringaschool.fuzupayapp.HolidayConstants.BASE_URL;
//import static com.moringaschool.fuzupayapp.HolidayConstants.HOLIDAY_URL;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HolidayClient {

    private static Retrofit retrofit = null;

    public static hrApi getClient() {

        if (retrofit == null) {
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(new Interceptor() {
                        @Override
                        public Response intercept(Chain chain) throws IOException {
                            Request newRequest  = chain.request().newBuilder()
                                    .addHeader("Authorization",API_KEY)
                                    .build();
                            return chain.proceed(newRequest);
                        }
                    })
                    .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(hrApi.class);
    }
}
