package com.example.rxctakehome.data.model

import com.example.rxctakehome.data.local.entity.LikeEntity

data class LikeDataModel(
    val brandName: String?,
    val discountRate: Double?,
    val consumerPrice: Int?,
    val name: String?,
    val price: Int?,
    val thumbnailUrl: String?,
) {
    fun toEntity(): LikeEntity {
        return LikeEntity(
            brandName = brandName ?: "",
            discountRate = discountRate,
            consumerPrice = consumerPrice,
            name = name ?: "",
            price = price,
            thumbnailUrl = thumbnailUrl,
        )
    }

    companion object {
        operator fun invoke(likeEntity: LikeEntity): LikeDataModel {
            return LikeDataModel(
                brandName = likeEntity.brandName,
                discountRate = likeEntity.discountRate,
                consumerPrice = likeEntity.consumerPrice,
                name = likeEntity.name,
                price = likeEntity.price,
                thumbnailUrl = likeEntity.thumbnailUrl,
            )
        }

        operator fun invoke(likeEntity: List<LikeEntity>): List<LikeDataModel> {
            return likeEntity.map { LikeDataModel(it) }
        }
    }
}
