package com.example.news24.presentation.api

import android.telecom.Call
import retrofit.call
import retrofit2.http.GET




interface NewoApi {
    @GET("value: pokemon")
    fun getNewsList : Call<NewsListResponse>

    @GET("value: pokemon{id}")
    fun getNewsDetail(@Path (value: "id") id: String) : Call<NewsResponse>
}