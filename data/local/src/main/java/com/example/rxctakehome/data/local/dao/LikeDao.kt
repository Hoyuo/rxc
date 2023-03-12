package com.example.rxctakehome.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.rxctakehome.data.local.entity.LikeEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface LikeDao {
    @Query("SELECT * FROM `like`")
    fun getItems(): Flow<List<LikeEntity>>

    @Query("SELECT * FROM `like` WHERE brandName = :brandName AND name = :name")
    suspend fun getItem(brandName: String, name: String): LikeEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: LikeEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(items: List<LikeEntity>)

    @Update
    suspend fun update(item: LikeEntity)

    @Delete
    suspend fun delete(item: LikeEntity)

    @Query("DELETE FROM `like` WHERE brandName = :brandName AND name = :name")
    suspend fun delete(brandName: String, name: String)

    @Query("DELETE FROM `like`")
    suspend fun deleteAll()
}
