package com.rija.foodmandu.api;

import com.rija.foodmandu.ui.Details;

import java.util.List;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface Super7 {
    @GET("super7")
    Call<List<Details>> getSuper7();
    @Multipart
    @POST("upload")
    Call<Details> uploadImage(@Part MultipartBody.Part img);
    @GET("super7")
    Call<Details> getImage(@Header("Authorization") String id);
}
