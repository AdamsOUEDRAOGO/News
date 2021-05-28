package com.example.news24.presentation.list

sealed class NewsModel

data class NewsSuccess(val newoList: List<News>) : NewsModel()
object NewsLoader : NewsModel()
object NewsError : NewsModel()