package com.example.rxctakehome.data.remote.service

import com.example.rxctakehome.data.remote.api.TaskApi
import com.example.rxctakehome.data.remote.model.GoodResponse
import javax.inject.Inject

class GoodServiceImpl @Inject constructor(
    private val taskApi: TaskApi,
) : GoodService {
    override suspend fun getGoodList(): List<GoodResponse> {
        return taskApi.getGoodsList()
    }
}
