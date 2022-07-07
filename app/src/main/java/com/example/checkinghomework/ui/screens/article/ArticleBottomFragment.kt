package com.example.checkinghomework.ui.screens.article

import android.os.Bundle
import android.text.util.Linkify
import android.view.View
import com.bumptech.glide.Glide
import com.example.checkinghomework.databinding.FragmentArticleBinding
import com.example.checkinghomework.model.ArticleModel
import com.example.checkinghomework.ui.screens.base.BaseBottomSheetFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ArticleBottomFragment : BaseBottomSheetFragment<FragmentArticleBinding>() {

    private var articleItem: ArticleModel? = null

    override fun getViewBinding(): FragmentArticleBinding =
        FragmentArticleBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getNavArguments()
        setArticleData()
        setCloseButton()
    }

    private fun setCloseButton() {
        binding.articleCloseBtn.setOnClickListener {
            dismiss()
        }
    }

    private fun getNavArguments() {
        articleItem =
            arguments?.let { ArticleBottomFragmentArgs.fromBundle(it).articleModel }
    }

    private fun setArticleData() {
        articleItem?.let {
            binding.articleTitle.text = it.title
            binding.articleAuthor.text = it.author
            binding.articleDescription.text = it.description
            binding.articleContent.text = it.content
            binding.articleCreatedAt.text = it.publishedAt

            binding.articleUrl.text = it.url
            Linkify.addLinks(binding.articleUrl, Linkify.ALL)

            Glide
                .with(requireContext())
                .load(it.urlToImage)
                .into(binding.articleImage)
        }
    }

}