package com.example.rxctakehome.data.remote.di

import com.example.rxctakehome.data.remote.api.TaskApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object APIModule {

    @Singleton
    @Provides
    fun provideAuthAPI(
        retrofit: Retrofit,
    ): TaskApi {
        return retrofit.create(TaskApi::class.java)
    }
}
