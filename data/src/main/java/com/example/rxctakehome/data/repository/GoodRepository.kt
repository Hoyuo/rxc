package com.example.rxctakehome.data.repository

import com.example.rxctakehome.data.model.GoodDataModel
import kotlinx.coroutines.flow.Flow

interface GoodRepository {
    suspend fun getListRemote(): List<GoodDataModel>

    fun getListLocal(): Flow<List<GoodDataModel>>

    suspend fun insert(goodDataModel: GoodDataModel)

    suspend fun insert(goodDataModelList: List<GoodDataModel>)
}
