package com.example.newsdetail_data.repository

import com.example.news_data.room.NewsDao
import com.example.news_domain.model.Article
import com.example.newsdetail_domain.repository.NewsDetailRepository

class NewsDetailRepoImplement(private val newsDao: NewsDao) :NewsDetailRepository {
    override suspend fun getNewsDetail(title: String): List<Article> {
        return newsDao.getNewsDetailArticle(title)
    }
}