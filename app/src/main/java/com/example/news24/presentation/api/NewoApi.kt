package com.example.news24.presentation.api

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


interface NewoApi {
    @GET("news")
    fun getNewsList(): Call<NewsListResponse>

    @GET("news{id}")
    fun getNewsDetail(@Path("id") id: Int) : Call<NewsResponse>
}