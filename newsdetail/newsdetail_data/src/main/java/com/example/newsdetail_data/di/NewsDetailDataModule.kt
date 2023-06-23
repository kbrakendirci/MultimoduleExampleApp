package com.example.newsdetail_data.di

import com.example.news_data.repository.NewsRepoImplement
import com.example.news_data.room.NewsDao
import com.example.news_domain.repository.NewsRepository
import com.example.newsdetail_data.repository.NewsDetailRepoImplement
import com.example.newsdetail_domain.repository.NewsDetailRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object NewsDetailDataModule {
    @Provides
    fun provideNewsDetailRepository(newsDao: NewsDao): NewsDetailRepository{
        return NewsDetailRepoImplement(newsDao)
    }

}