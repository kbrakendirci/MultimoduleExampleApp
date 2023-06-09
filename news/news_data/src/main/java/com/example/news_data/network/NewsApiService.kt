package com.example.news_data.network

import com.example.common_utils.Constant
import com.example.news_data.model.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {
    //https://newsapi.org/v2/everything?q=tesla&from=2023-05-08&sortBy=publishedAt&apiKey=30afea954e6a476cb77f25936d148f6d
    @GET("top-headlines")
    suspend fun getNewsArticles(
        @Query("country") country:String,
        @Query("category") category: String=Constant.CATEGORY,
        @Query("apiKey") apiKey:String = Constant.API_KEY
    ):NewsResponse
}