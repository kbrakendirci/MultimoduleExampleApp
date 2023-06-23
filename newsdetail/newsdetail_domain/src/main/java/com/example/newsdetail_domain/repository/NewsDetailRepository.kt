package com.example.newsdetail_domain.repository

import com.example.news_domain.model.Article


interface NewsDetailRepository {
    suspend fun getNewsDetail(title:String):List<Article>
}