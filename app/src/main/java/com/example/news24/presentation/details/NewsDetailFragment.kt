package com.example.news24.presentation.details
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.news24.R
import com.example.news24.presentation.Singletons
import com.example.news24.presentation.api.NewsDetailResponse
import com.example.news24.presentation.api.NewsListResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class NewsDetailFragment : Fragment() {

    private lateinit var textViewName: TextView

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textViewName = view.findViewById(R.id.news_detail_name)
        callApi()
    }

    private fun callApi() {

        val id= arguments?.getInt("newsId") ?: -1
        Singletons.newoApi.getNewsDetail(id).enqueue(object : Callback<NewsDetailResponse> {
            override fun onFailure(call: Call<NewsDetailResponse>, t: Throwable
            ) {
                TODO("Not yet implemented")
            }

            override fun onResponse(
                call: Call<NewsDetailResponse>,
                responce: Response<NewsListResponse>
            ) {

                if (response.isSuccessful && response.body() != null) {

                    textViewName.text = response.body()!!.name
                }
            }
        }
        )
        TODO("Not yet implemented")
    }
}