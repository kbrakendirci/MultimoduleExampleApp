package com.example.multimoduleexampleapp

import android.content.Context
import com.example.common_utils.Navigator
import com.example.multimoduleexampleapp.navigation.DefaultNavigator
import com.example.multimoduleexampleapp.room.AppDatabase
import com.example.news_data.room.NewsDao
import com.example.newsdetail_data.room.NewsDetailDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object MainModule {

    @Provides
    @Singleton
    fun provideProvider(): Navigator.Provider{
        return DefaultNavigator()
    }

    @Provides
    @Singleton
    fun provideNewsDatabase(@ApplicationContext context: Context):AppDatabase{
        return AppDatabase.getInstance(context)
    }

    @Provides
    fun provideNewsDao(appDatabase: AppDatabase):NewsDao{
        return appDatabase.getNewsDao()
    }

    @Provides
    fun provideNewsDetailDao(appDatabase: AppDatabase):NewsDetailDao{
        return appDatabase.getNewsDetailDao()
    }
}