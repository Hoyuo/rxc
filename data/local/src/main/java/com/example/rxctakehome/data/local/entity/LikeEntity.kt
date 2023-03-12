package com.example.rxctakehome.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "like", primaryKeys = ["brandName", "name"])
data class LikeEntity(
    @ColumnInfo(name = "brandName")
    val brandName: String, // 온호프
    @ColumnInfo(name = "name")
    val name: String, // 바디케어 2종 쏘 컴포트 (리퀴드솝,바디로션)
    @ColumnInfo(name = "discountRate")
    val discountRate: Double?, // 0
    @ColumnInfo(name = "consumerPrice")
    val consumerPrice: Int?, // 47000
    @ColumnInfo(name = "price")
    val price: Int?, // 47000
    @ColumnInfo(name = "thumbnailUrl")
    val thumbnailUrl: String?, // https://cdn-image.prizm.co.kr/goods/20220401/73c5e0b1-d61f-43ef-a992-7c5f9a818393.jpeg
)
