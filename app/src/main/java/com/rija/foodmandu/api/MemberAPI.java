package com.rija.foodmandu.api;

import com.rija.foodmandu.ui.member;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MemberAPI {
    @GET("member")
    Call<List<member>> getmember();
}
