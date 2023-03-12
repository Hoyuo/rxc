package com.example.rxctakehome.data.repository

import com.example.rxctakehome.data.local.dao.LikeDao
import com.example.rxctakehome.data.model.LikeDataModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LikeRepositoryImpl @Inject constructor(
    private val likeDao: LikeDao,
) : LikeRepository {
    override fun getLikeList(): Flow<List<LikeDataModel>> {
        return likeDao.getItems().map { LikeDataModel(it) }
    }

    override suspend fun getLike(brandName: String, name: String): LikeDataModel? {
        return likeDao.getItem(brandName, name)?.let { LikeDataModel(it) }
    }

    override suspend fun addLike(like: LikeDataModel) {
        return likeDao.insert(like.toEntity())
    }

    override suspend fun addLike(likes: List<LikeDataModel>) {
        return likeDao.insert(likes.map { it.toEntity() })
    }

    override suspend fun removeLike(brandName: String, name: String) {
        return likeDao.delete(brandName, name)
    }

    override suspend fun removeLike(like: LikeDataModel) {
        return likeDao.delete(like.toEntity())
    }
}
