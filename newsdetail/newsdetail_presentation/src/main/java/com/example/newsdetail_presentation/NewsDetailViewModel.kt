package com.example.newsdetail_presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common_utils.Resource
import com.example.newsdetail_domain.usecase.GetNewsDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsDetailViewModel @Inject constructor(
    private val getNewsDetailUseCase: GetNewsDetailUseCase
):ViewModel(){
    private  val _newsArticle = MutableStateFlow(NewsState())
    val newsArticle : StateFlow<NewsState> = _newsArticle

    init {
        //getNewsArticles()
    }

    fun getNewsCategory(title:String){
        viewModelScope.launch {
            getNewsDetailUseCase.invoke(title).collect{
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