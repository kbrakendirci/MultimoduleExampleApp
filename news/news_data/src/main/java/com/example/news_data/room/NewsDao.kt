package com.example.news_data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.news_domain.model.Article

@Dao
interface NewsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertList(list: List<Article>)

    @Query("SELECT * FROM Article")
    suspend fun getNesArticle():List<Article>

    @Query("SELECT * FROM Article Where title=:newsTitle")
    suspend fun getNewsDetailArticle(newsTitle:String): List<Article>
}