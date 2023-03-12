package com.example.rxctakehome.data.repository

import com.example.rxctakehome.data.local.dao.GoodDao
import com.example.rxctakehome.data.model.GoodDataModel
import com.example.rxctakehome.data.remote.service.GoodService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GoodRepositoryImpl @Inject constructor(
    private val goodDao: GoodDao,
    private val goodService: GoodService,
) : GoodRepository {
    override suspend fun getListRemote(): List<GoodDataModel> {
        return goodService.getGoodList().map { GoodDataModel(it) }
    }

    override fun getListLocal(): Flow<List<GoodDataModel>> {
        return goodDao.getItems().map { GoodDataModel(it) }
    }

    override suspend fun insert(goodDataModel: GoodDataModel) {
        goodDao.insert(goodDataModel.toEntity())
    }

    override suspend fun insert(goodDataModelList: List<GoodDataModel>) {
        goodDao.insert(goodDataModelList.map { it.toEntity() })
    }
}
