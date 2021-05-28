package com.example.news24.presentation.api

import android.os.Parcel
import android.os.Parcelable
import com.example.news24.presentation.list.News
data class NewsListResponse(

        val count: Int,
        val next: String,
        val results: List<News>
        )