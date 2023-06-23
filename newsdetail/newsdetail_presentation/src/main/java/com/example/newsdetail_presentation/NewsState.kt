package com.example.newsdetail_presentation

data class NewsState(
    val isLoading:Boolean=false,
    val error:String="",
    val data: List<Any>? =null
)

