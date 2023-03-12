package com.example.rxctakehome.data.remote.api

import com.example.rxctakehome.data.remote.model.GoodResponse
import retrofit2.http.GET

interface TaskApi {
    @GET("/goodslist.json")
    suspend fun getGoodsList(): List<GoodResponse>
}
