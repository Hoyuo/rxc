package com.example.rxctakehome.data.remote.service

import com.example.rxctakehome.data.remote.model.GoodResponse

interface GoodService {
    suspend fun getGoodList(): List<GoodResponse>
}
