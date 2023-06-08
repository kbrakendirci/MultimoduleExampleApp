package com.example.multimoduleexampleapp

import com.example.common_utils.Navigator
import com.example.multimoduleexampleapp.navigation.DefaultNavigator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
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

}