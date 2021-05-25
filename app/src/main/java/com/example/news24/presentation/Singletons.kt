package com.example.news24.presentation

import android.accessibilityservice.GestureDescription
import com.example.news24.presentation.api.NewoApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Singletons {

        val newoApi: NewoApi = Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(NewoApi::class.java)

    }
}