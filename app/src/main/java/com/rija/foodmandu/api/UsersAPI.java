package com.rija.foodmandu.api;

import com.rija.foodmandu.model.User;
import com.rija.foodmandu.serverresponse.ImageResponse;
import com.rija.foodmandu.serverresponse.SignUpResponse;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface UsersAPI {

    @POST("user/signup")
    Call<SignUpResponse> registerUser(@Body User users);

    @FormUrlEncoded
    @POST("user/login")
    Call<SignUpResponse> checkUser(@Field("username") String username, @Field("password") String password);

    @Multipart
    @POST("upload")
    Call<ImageResponse> uploadImage(@Part MultipartBody.Part img);

    @GET("user/me")
    Call<User> getUserDetails(@Header("Authorization") String token);

}