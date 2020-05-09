package com.unc0ded.restapidemo.retrofit;

import com.unc0ded.restapidemo.models.RandomUser;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface RetrofitAPIInterface {

    @GET("api/")
    Call<RandomUser> getUser(@QueryMap Map<String, String> map);

//    @GET("")
//    Call<RandomUser> getUser();
}
