package com.tes.eat.anywhere.bottomnavigationapp.ui.news

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.tes.eat.anywhere.bottomnavigationapp.R
import com.tes.eat.anywhere.bottomnavigationapp.databinding.FragmentNewsBinding
import com.tes.eat.anywhere.bottomnavigationapp.model.data.news.News
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsFragment : Fragment() {

    lateinit var binding: FragmentNewsBinding

    private val viewModel by activityViewModels<NewsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNewsBinding.inflate(inflater)
        val swipeRefreshLayout = binding.swipeContainer
        // observe the changes in viewmodel liveData
        viewModel.news.observe(viewLifecycleOwner) {
            setupUI(it)
        }
        viewModel.getNews()
        swipeRefreshLayout.setOnRefreshListener{
            // observe the changes in viewmodel liveData
            viewModel.news.observe(viewLifecycleOwner) {
                setupUI(it)
            }
            viewModel.getNews()
            // This line is important as it explicitly refreshes only once
            // If "true" it implicitly refreshes forever
            swipeRefreshLayout.isRefreshing = false
        }

        return binding.root
    }

    private fun setupUI(newsList: News) {
        binding.rvNews.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = NewsAdapter(
                newsList
            )
        }
    }
}
