package com.example.news_domain.di

import com.example.news_domain.repository.NewsRepository
import com.example.news_domain.usecase.GetNewsArticleUseCase
import com.example.news_domain.usecase.GetNewsCategoryUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object NewsDomainModule {
    @Provides
    fun provideGetNewsUseCase(newsRepository: NewsRepository):GetNewsArticleUseCase{
        return GetNewsArticleUseCase(newsRepository)
    }

    @Provides
    fun provideGetNewsCategoryUseCase(newsRepository: NewsRepository):GetNewsCategoryUseCase{
        return GetNewsCategoryUseCase(newsRepository)
    }
}