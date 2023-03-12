package com.example.rxctakehome.domain.model

import com.example.rxctakehome.data.model.GoodDataModel

data class GoodDomainModel(
    val brandName: String?,
    val discountRate: Double?,
    val consumerPrice: Int?,
    val name: String?,
    val price: Int?,
    val thumbnailUrl: String?,
) {
    companion object {
        operator fun invoke(dataModel: GoodDataModel) = GoodDomainModel(
            brandName = dataModel.brandName,
            discountRate = dataModel.discountRate,
            consumerPrice = dataModel.consumerPrice,
            name = dataModel.name,
            price = dataModel.price,
            thumbnailUrl = dataModel.thumbnailUrl,
        )

        operator fun invoke(dataModelList: List<GoodDataModel>) = dataModelList.map { GoodDomainModel(it) }
    }
}
