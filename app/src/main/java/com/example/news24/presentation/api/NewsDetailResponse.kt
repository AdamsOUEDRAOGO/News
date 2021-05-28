package com.example.news24.presentation.api

data class NewsDetailResponse(
        val name : String,
        val types: List<NewsSlot>
)

data class NewsSlot(
        val slot: Int,
        val type: NewsType
)
data class NewsType(
        val name: String,
        val url: String
)