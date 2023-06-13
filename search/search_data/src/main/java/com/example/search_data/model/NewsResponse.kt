package com.example.search_data.model

import com.example.search_data.model.ArticleDTO

data class NewsResponse(
    val articles: List<ArticleDTO>,
    val status: String,
    val totalResults: Int
)