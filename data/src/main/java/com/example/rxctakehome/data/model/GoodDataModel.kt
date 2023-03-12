package com.example.rxctakehome.data.model

import com.example.rxctakehome.data.local.entity.GoodEntity
import com.example.rxctakehome.data.remote.model.GoodResponse

data class GoodDataModel(
    val brandName: String?,
    val discountRate: Double?,
    val consumerPrice: Int?,
    val name: String?,
    val price: Int?,
    val thumbnailUrl: String?,
) {
    fun toEntity(): GoodEntity {
        return GoodEntity(
            brandName = brandName ?: "",
            discountRate = discountRate,
            consumerPrice = consumerPrice,
            name = name ?: "",
            price = price,
            thumbnailUrl = thumbnailUrl,
        )
    }

    companion object {
        operator fun invoke(response: GoodResponse): GoodDataModel {
            return GoodDataModel(
                brandName = response.brandName,
                discountRate = response.discountRate,
                consumerPrice = response.consumerPrice,
                name = response.name,
                price = response.price,
                thumbnailUrl = response.thumbnailUrl,
            )
        }

        @JvmName("list_goodResponse_to_list_goodDataModel")
        operator fun invoke(response: List<GoodResponse>): List<GoodDataModel> {
            return response.map { GoodDataModel(it) }
        }

        operator fun invoke(entity: GoodEntity): GoodDataModel {
            return GoodDataModel(
                brandName = entity.brandName,
                discountRate = entity.discountRate,
                consumerPrice = entity.consumerPrice,
                name = entity.name,
                price = entity.price,
                thumbnailUrl = entity.thumbnailUrl,
            )
        }

        @JvmName("list_goodEntity_to_list_goodDataModel")
        operator fun invoke(entity: List<GoodEntity>): List<GoodDataModel> {
            return entity.map { GoodDataModel(it) }
        }
    }
}
