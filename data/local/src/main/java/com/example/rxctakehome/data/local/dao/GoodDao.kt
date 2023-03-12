package com.example.rxctakehome.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.rxctakehome.data.local.entity.GoodEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface GoodDao {
    @Query("SELECT * FROM `good`")
    fun getItems(): Flow<List<GoodEntity>>

    @Query("SELECT * FROM `good` WHERE brandName = :brandName AND name = :name")
    suspend fun getItem(brandName: String, name: String): GoodEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: GoodEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(items: List<GoodEntity>)

    @Update
    suspend fun update(item: GoodEntity)

    @Delete
    suspend fun delete(item: GoodEntity)

    @Query("DELETE FROM `good` WHERE brandName = :brandName AND name = :name")
    suspend fun delete(brandName: String, name: String)

    @Query("DELETE FROM `good`")
    suspend fun deleteAll()
}
