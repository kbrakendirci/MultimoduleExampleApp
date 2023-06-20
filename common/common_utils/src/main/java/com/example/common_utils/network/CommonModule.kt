package com.example.common_utils.network

import android.app.Application
import android.util.Log
import com.example.common_utils.BuildConfig
import com.example.common_utils.Constant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import javax.net.ssl.HostnameVerifier
import javax.net.ssl.HttpsURLConnection

@InstallIn(SingletonComponent::class)
@Module
object CommonModule {

    @Provides
    @Singleton
    fun provideRetrofit(okHttp: OkHttpClient): Retrofit {
        return Retrofit.Builder().baseUrl(Constant.BASE_URL).client(okHttp).addConverterFactory(
            GsonConverterFactory.create()

        ).build()
    }


    @Singleton
    @Provides
    fun provideOkHttp(app: Application): OkHttpClient {
        return OkHttpClient.Builder().apply {
            connectTimeout(120, TimeUnit.SECONDS)
            readTimeout(60, TimeUnit.SECONDS)
            writeTimeout(60, TimeUnit.SECONDS)
            //addInterceptor(requestInterceptor)
            val interceptor = HttpLoggingInterceptor { message ->
                try {
                    if (BuildConfig.DEBUG) {
                        Log.d("okhttp", message)
                    }
                    //app.writeToLogFile(message)
                } catch (e: Exception) {

                }
            }

            interceptor.level = HttpLoggingInterceptor.Level.BODY
            addInterceptor(interceptor)
        }.build()
    }

}