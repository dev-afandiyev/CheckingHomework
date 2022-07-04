package com.example.checkinghomework.ui.screens.news

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.checkinghomework.databinding.FragmentNewsBinding
import com.example.checkinghomework.ui.screens.base.BaseFragment
import com.example.checkinghomework.ui.screens.news.adapter.NewsAdapter
import com.example.checkinghomework.viewmodel.NewsViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class NewsFragment : BaseFragment<FragmentNewsBinding>() {

    private val viewModel: NewsViewModel by viewModels()
    private var newsAdapter: NewsAdapter? = null

    override fun getViewBinding() =
        FragmentNewsBinding.inflate(layoutInflater)

    override fun onStart() {
        super.onStart()
        viewModel.apiRequest()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAdapter()

        viewModel.getNewsLiveData().observe(viewLifecycleOwner) {
            it?.let {
                newsAdapter?.initAdapter(it)
                binding.progressBar.visibility = View.GONE
            }
        }
    }

    private fun setAdapter() {
        newsAdapter = NewsAdapter()
        binding.newsList.layoutManager = LinearLayoutManager(requireContext())
        binding.newsList.adapter = newsAdapter

        newsAdapter?.onClickListener {

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.newsList.removeAllViews()
        binding.newsLayout.removeAllViews()
        binding.newsLayout.removeAllViewsInLayout()
    }

}