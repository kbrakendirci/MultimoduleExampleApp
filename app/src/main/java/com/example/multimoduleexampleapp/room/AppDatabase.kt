package com.example.multimoduleexampleapp.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.news_data.room.NewsDao
import com.example.news_domain.model.Article
import com.example.newsdetail_data.room.NewsDetailDao

@Database(entities = [Article::class], version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    companion object {
        fun getInstance(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, "app_db")
                .fallbackToDestructiveMigration().build()
        }
    }

    abstract fun getNewsDao():NewsDao

    abstract fun getNewsDetailDao():NewsDetailDao

}