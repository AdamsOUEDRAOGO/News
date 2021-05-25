package com.example.news24.presentation.list

import android.accessibilityservice.GestureDescription
import android.os.Bundle
import android.telecom.Call
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.news24.R
import com.example.news24.presentation.Singletons
import com.example.news24.presentation.api.NewoApi
import com.example.news24.presentation.api.NewsListResponse
import javax.security.auth.callback.Callback


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class NewsListFragment : Fragment() {

    private lateinit var recycleView: RecyclerView
    private val adapter = NewsAdapter(listOf(), ::onClickedNews)

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recycleView = view.findViewById(R.id.news_recyclerview)

        recycleView.apply {

            layoutManager = LinearLayoutManager(context)
            adapter = this@NewsListFragment.adapter
        }

        val list:List<News> = getListFromCache()
        if(list.isEmpty()) {
            callApi()
        }
        else{
            showList(list)
        }
    }
    private fun getListFromCache(): List<News>{

    }

    private fun saveListIntoCache() {
        TODO("Not yet implemented")
    }

    private fun callApi() {
        Singletons.newoApi.getNewsList().enqueue(object : Callback<NewsListResponse> {
            override fun onFailure(call: Call<NewsListResponse>, t: Throwable) {
                //TODO("Not implemented")
            }

            override fun onResponse(
                call: Call<NewsListResponse>,
                responce: Response<NewsListResponse>
            ) {
                if (response.isSucceful && response.body() != null) {
                    val newsResponse: NewsListResponse = response.body()!!
                    saveListIntoCache()
                    showList(newsResponse.results)
                }
            }
        })
    }


    private fun showList(newoList: List<News>) {
                    adapter.updateList(newoList)
    }

    private fun onClickedNews(id: Int) {
        findNavController().navigate(R.id.navigateToNewsDetailFragment, bundleOf(
            "newsId" to (id + 1)
        ))
    }
}

