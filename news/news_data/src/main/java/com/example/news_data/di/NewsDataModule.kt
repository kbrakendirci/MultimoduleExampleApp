package com.example.news_data.di

import android.util.Log
import com.example.news_data.network.NewsApiService
import com.example.news_data.repository.NewsRepoImplement
import com.example.news_domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@InstallIn(SingletonComponent::class)
@Module
object NewsDataModule {

    @Provides
    fun provideNewsApiService(retrofit: Retrofit): NewsApiService {
        Log.d("okHttp","${retrofit.create(NewsApiService::class.java)}")
        return retrofit.create(NewsApiService::class.java)
    }


    @Provides
    fun provideNewsRepository(newsApiService: NewsApiService): NewsRepository {
        return NewsRepoImplement(newsApiService)
    }


}