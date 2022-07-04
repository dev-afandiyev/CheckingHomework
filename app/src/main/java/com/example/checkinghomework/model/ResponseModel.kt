package com.example.checkinghomework.model

data class ResponseModel(
    val status: String,
    val totalResults: String,
    val articles: ArrayList<ArticleModel>
)

data class ArticleModel(
    val author: String,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String,
    val publishedAt: String,
    val content: String
)
