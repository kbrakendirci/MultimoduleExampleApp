package com.example.newsdetail_data.room


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.newsdetail_domain.model.Article

@Dao
interface NewsDetailDao {
/*
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertList(list: List<Article>)

    @Query("SELECT * FROM Article")
    suspend fun getNewsArticle(title:String):List<Article>

 */
}