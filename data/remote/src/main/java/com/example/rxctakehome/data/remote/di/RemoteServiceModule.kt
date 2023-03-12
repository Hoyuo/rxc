package com.example.rxctakehome.data.remote.di

import com.example.rxctakehome.data.remote.service.GoodService
import com.example.rxctakehome.data.remote.service.GoodServiceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class RemoteServiceModule {

    @Singleton
    @Binds
    abstract fun bindGoodService(taskService: GoodServiceImpl): GoodService
}
