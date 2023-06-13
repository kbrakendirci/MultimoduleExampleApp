package com.example.search_presantation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common_utils.Resource
import com.example.search_domain.usecase.GetSearchArticleUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject



@HiltViewModel
class SearchViewModel @Inject constructor(private val getSearchArticleUseCase: GetSearchArticleUseCase) :
    ViewModel() {

    private val _searchArticles = MutableStateFlow(SearchState())
    val searchArticles: StateFlow<SearchState> = _searchArticles


    fun getSearchArticles(map: MutableMap<String, String>) {
        getSearchArticleUseCase(map).onEach {

            when (it) {
                is Resource.Loading -> {
                    _searchArticles.value = SearchState(isLoading = true)
                }
                is Resource.Error -> {
                    _searchArticles.value = SearchState(error = it.message)
                }
                is Resource.Success -> {
                    _searchArticles.value = SearchState(data = it.data)
                }
            }
        }.launchIn(viewModelScope)
    }

}