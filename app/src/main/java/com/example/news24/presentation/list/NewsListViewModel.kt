package com.example.news24.presentation.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.news24.presentation.Singletons
import com.example.news24.presentation.api.NewsListResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private val <T> Response<T>.isSucceful: Boolean
    get() {}

class NewsListViewModel : ViewModel(){

    val newoList : MutableLiveData<NewsModel> = MutableLiveData()

    init {
        callApi()
    }
    private fun callApi() {

        newoList.value = NewsLoader

        Singletons.newoApi.getNewsList().enqueue(object : Callback<NewsListResponse> {
            override fun onFailure(call: Call<NewsListResponse>, t: Throwable) {
                newoList.value = NewsError
            }
            override fun onResponse(call: Call<NewsListResponse>, response: Response<NewsListResponse>
            ) {
                if (response.isSucceful && response.body() != null) {
                    val newsResponse: NewsListResponse = response.body()!!
                    newoList.value = NewsSuccess(newsResponse.results)
                }
                else{
                    newoList.value = NewsError
                }
            }
        })
    }

}