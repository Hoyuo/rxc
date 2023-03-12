package com.example.rxctakehome.data.di

import com.example.rxctakehome.data.repository.GoodRepository
import com.example.rxctakehome.data.repository.GoodRepositoryImpl
import com.example.rxctakehome.data.repository.LikeRepository
import com.example.rxctakehome.data.repository.LikeRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class DataModule {
    @Singleton
    @Binds
    abstract fun bindGoodRepository(impl: GoodRepositoryImpl): GoodRepository

    @Singleton
    @Binds
    abstract fun bindsLikeRepository2(impl: LikeRepositoryImpl): LikeRepository
}
