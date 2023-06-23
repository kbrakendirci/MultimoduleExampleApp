package com.example.newsdetail_domain.di

import com.example.newsdetail_domain.repository.NewsDetailRepository
import com.example.newsdetail_domain.usecase.GetNewsDetailUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object NewsDetailDomainModule {
    @Provides
    fun provideGetNewsDetail(newsDetailRepository: NewsDetailRepository):GetNewsDetailUseCase{
        return GetNewsDetailUseCase(newsDetailRepository)
    }
}