package com.example.news24.presentation

import android.accessibilityservice.GestureDescription
import com.example.news24.presentation.api.NewoApi
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File

class Singletons {

        var cache = Cache(File(context?.cacheDir, "responses"),2*1024*1024)//10MB

        val okhttpClient: OkHttpClient = OkHttpClient().newBuilder()
                .cache(cache)
                .build()
        val newoApi: NewoApi = Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okhttpClient)
                .build()
                .create(NewoApi::class.java)
    }
}