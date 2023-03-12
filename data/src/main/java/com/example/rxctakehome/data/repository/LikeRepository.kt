package com.example.rxctakehome.data.repository

import com.example.rxctakehome.data.model.LikeDataModel
import kotlinx.coroutines.flow.Flow

interface LikeRepository {
    fun getLikeList(): Flow<List<LikeDataModel>>
    suspend fun getLike(brandName: String, name: String): LikeDataModel?
    suspend fun addLike(like: LikeDataModel)
    suspend fun addLike(likes: List<LikeDataModel>)
    suspend fun removeLike(brandName: String, name: String)
    suspend fun removeLike(like: LikeDataModel)
}
