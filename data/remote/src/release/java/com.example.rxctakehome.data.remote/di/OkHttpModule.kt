package com.example.rxctakehome.data.remote.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object OkHttpModule {

    private const val READ_TIME_OUT = 60L
    private const val CONNECT_TIME_OUT = 60L

    @LogInterceptor
    @Singleton
    @Provides
    fun provideHttpLoggingInterceptor(): Interceptor {
        return HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.NONE)
        }
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(
        @LogInterceptor logInterceptor: Interceptor,
        @UserInterceptor userInterceptor: Interceptor
    ): OkHttpClient {
        val okhttpClient = OkHttpClient.Builder()
            .connectTimeout(CONNECT_TIME_OUT, TimeUnit.SECONDS) // connect timeout
            .readTimeout(READ_TIME_OUT, TimeUnit.SECONDS) // read timeout
            .addInterceptor(userInterceptor)
            .addInterceptor(logInterceptor)

        return okhttpClient.build()
    }
}
