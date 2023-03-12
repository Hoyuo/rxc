package com.example.rxctakehome.data.local.di

import android.content.Context
import androidx.room.Room
import com.example.rxctakehome.data.local.db.LocalDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object LocalModule {
    @Singleton
    @Provides
    fun provideLocalDatabase(
        @ApplicationContext context: Context,
    ): LocalDatabase {
        return Room
            .databaseBuilder(
                context.applicationContext,
                LocalDatabase::class.java,
                "like_list_database.db"
            )
            .build()
    }

    @Singleton
    @Provides
    fun provideLikeDao(database: LocalDatabase) = database.likeDao()

    @Singleton
    @Provides
    fun provideGoodDao(database: LocalDatabase) = database.goodDao()
}
