package com.example.news_presentation

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common_utils.Resource
import com.example.news_domain.model.Article
import com.example.news_domain.usecase.GetNewsArticleUseCase
import com.example.news_domain.usecase.GetNewsCategoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val getNewsArticleUseCase: GetNewsArticleUseCase,
    private val getNewsCategoryUseCase: GetNewsCategoryUseCase

    ):ViewModel(){
    private  val _newsArticle = MutableStateFlow(NewsState())
    val newsArticle : StateFlow<NewsState> = _newsArticle

    init {
        //getNewsArticles()
    }
/*

    fun getNewsArticles(){
        getNewsArticleUseCase().onEach {
            when(it){
                is Resource.Success->{
                    _newsArticle.value = NewsState(data = it.data)
                }
                is Resource.Error ->{
                    _newsArticle.value = NewsState(error = it.message)
                }
                is Resource.Loading ->{
                    _newsArticle.value = NewsState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
    */
   fun getNewsCategory(category:String){
    viewModelScope.launch {
        getNewsCategoryUseCase.invoke(category).collect{
            when(it){
                is Resource.Success->{
                    _newsArticle.value = NewsState(data = it.data)
                }
                is Resource.Error ->{
                    _newsArticle.value = NewsState(error = it.message)
                }
                is Resource.Loading ->{
                    _newsArticle.value = NewsState(isLoading = true)
                }
            }
        }
    }
   }
}