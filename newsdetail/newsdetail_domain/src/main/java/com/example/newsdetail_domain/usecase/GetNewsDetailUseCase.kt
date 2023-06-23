package com.example.newsdetail_domain.usecase

import com.example.common_utils.Resource
import com.example.news_domain.model.Article
import com.example.newsdetail_domain.repository.NewsDetailRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetNewsDetailUseCase(private val newsDetailRepository: NewsDetailRepository) {
    operator fun invoke(title:String):Flow<Resource<List<Article>>> = flow {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(data=newsDetailRepository.getNewsDetail(title)))
        }catch (e:Exception){
            emit(Resource.Error(message = e.message.toString()))
        }
    }
}