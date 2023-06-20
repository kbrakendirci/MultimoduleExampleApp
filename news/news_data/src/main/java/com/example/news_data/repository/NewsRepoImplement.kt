package com.example.news_data.repository

import com.example.news_data.mapper.toDomainArticle
import com.example.news_data.network.NewsApiService
import com.example.news_data.room.NewsDao
import com.example.news_domain.model.Article
import com.example.news_domain.repository.NewsRepository

class NewsRepoImplement(private val newsApiService: NewsApiService,private val newsDao: NewsDao) :NewsRepository{
    override suspend fun getNewsArticle(): List<Article> {
       return try {
            val temp = newsApiService.getNewsArticles(country ="us").articles.map { it.toDomainArticle() }
            newsDao.insertList(temp)
            newsDao.getNesArticle()
        }catch (e:Exception){
            newsDao.getNesArticle()
        }
    }

    override suspend fun getNewsCategory(category: String): List<Article> {
       return try {
           val temp = newsApiService.getNewsCategory(country = "us", category = category).articles.map { it.toDomainArticle() }
           newsDao.insertList(temp)
           newsDao.getNesArticle()
       }catch (e:Exception){
           newsDao.getNesArticle()
       }
    }
}