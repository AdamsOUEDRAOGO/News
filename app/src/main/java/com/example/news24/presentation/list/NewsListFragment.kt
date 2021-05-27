package com.example.news24.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.news24.R


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class NewsListFragment : Fragment() {

    private lateinit var recycleView: RecyclerView
    private val adapter = NewsAdapter(listOf(), ::onClickedNews)
    private val viewModel: NewsListViewModel by viewModels()

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

        viewModel.newoList.observe(viewLifecycleOwner, Observer { list ->
            adapter.updateList(list)
        })

    }


    private fun onClickedNews(id: Int) {
        findNavController().navigate(R.id.navigateToNewsDetailFragment, bundleOf(
            "newsId" to (id + 1)
        ))
    }
}

