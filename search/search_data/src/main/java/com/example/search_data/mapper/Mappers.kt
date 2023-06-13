package com.example.search_data.mapper

import com.example.search_data.model.ArticleDTO
import com.example.search_domain.model.Article


fun ArticleDTO.toDomainArticle(): Article {
    return Article(
        author = this.author?:"",
        content = this.content?:"",
        description = this.description?:"",
        title = this.title?:"",
        urlToImage = this.urlToImage?:""
    )
}