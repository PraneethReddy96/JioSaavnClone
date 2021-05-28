package com.example.saavn_app_praneeth;


    import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

    public class ApiNetwork {

        private static final HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);

        public static Retrofit getRetrofitInstance(){
            return new Retrofit.Builder()
                    .baseUrl("https://itunes.apple.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build())
                    .build();
        }
    }

