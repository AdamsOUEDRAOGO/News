package com.example.news24.presentation.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.news24.presentation.Singletons
import com.example.news24.presentation.api.NewsListResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsListViewModel : ViewModel(){

    val newoList : MutableLiveData<List<News>> = MutableLiveData()

    init {
        callApi()
    }
    private fun callApi() {

        Singletons.newoApi.getNewsList().enqueue(object : Callback<NewsListResponse> {
            override fun onFailure(call: Call<NewsListResponse>, t: Throwable) {
                //TODO("Not implemented")
            }
            override fun onResponse(call: Call<NewsListResponse>, response: Response<NewsListResponse>
            ) {
                if (response.isSucceful && response.body() != null) {
                    val newsResponse: NewsListResponse = response.body()!!
                    newoList.value = newsResponse.results
                }
            }
        })
    }

}