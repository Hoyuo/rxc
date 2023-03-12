package com.example.rxctakehome.domain.model

import com.example.rxctakehome.data.model.LikeDataModel

data class LikeDomainModel(
    val brandName: String?,
    val discountRate: Double?,
    val consumerPrice: Int?,
    val name: String?,
    val price: Int?,
    val thumbnailUrl: String?,
) {
    fun toDataModel(): LikeDataModel {
        return LikeDataModel(
            brandName = brandName,
            discountRate = discountRate,
            consumerPrice = consumerPrice,
            name = name,
            price = price,
            thumbnailUrl = thumbnailUrl,
        )
    }

    companion object {
        operator fun invoke(dataModel: LikeDataModel) = LikeDomainModel(
            brandName = dataModel.brandName,
            discountRate = dataModel.discountRate,
            consumerPrice = dataModel.consumerPrice,
            name = dataModel.name,
            price = dataModel.price,
            thumbnailUrl = dataModel.thumbnailUrl,
        )

        operator fun invoke(dataModelList: List<LikeDataModel>) = dataModelList.map { LikeDomainModel(it) }
    }
}
