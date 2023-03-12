package com.example.rxctakehome.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.rxctakehome.data.local.dao.GoodDao
import com.example.rxctakehome.data.local.dao.LikeDao
import com.example.rxctakehome.data.local.entity.GoodEntity
import com.example.rxctakehome.data.local.entity.LikeEntity

@Database(entities = [LikeEntity::class, GoodEntity::class], version = 1, exportSchema = false)
abstract class LocalDatabase : RoomDatabase() {
    abstract fun goodDao(): GoodDao
    abstract fun likeDao(): LikeDao
}
