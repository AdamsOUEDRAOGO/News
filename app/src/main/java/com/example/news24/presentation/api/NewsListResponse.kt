package com.example.news24.presentation.api

import com.example.news24.presentation.list.News
data class NewsListResponse{

        val count: Int,
        val next: String,
        val results: List<News>

}