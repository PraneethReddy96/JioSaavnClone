package com.example.saavn_app_praneeth;


import com.example.saavn_app_praneeth.Response.ResponseModel;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {

   @GET("/search")
   Call<ResponseModel> getSongs(@Query("term")String search);

}
