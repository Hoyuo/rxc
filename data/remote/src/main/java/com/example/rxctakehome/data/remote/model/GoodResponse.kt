package com.example.rxctakehome.data.remote.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GoodResponse(
    @Json(name = "brandName")
    val brandName: String? = null, // 온호프
    @Json(name = "discountRate")
    val discountRate: Double? = null, // 0
    @Json(name = "consumerPrice")
    val consumerPrice: Int? = null, // 47000
    @Json(name = "name")
    val name: String? = null, // 바디케어 2종 쏘 컴포트 (리퀴드솝,바디로션)
    @Json(name = "price")
    val price: Int? = null, // 47000
    @Json(name = "thumbnailUrl")
    val thumbnailUrl: String? = null, // https://cdn-image.prizm.co.kr/goods/20220401/73c5e0b1-d61f-43ef-a992-7c5f9a818393.jpeg
)
