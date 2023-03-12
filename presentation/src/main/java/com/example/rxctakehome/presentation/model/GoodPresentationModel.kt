package com.example.rxctakehome.presentation.model

import androidx.recyclerview.widget.DiffUtil
import com.example.rxctakehome.domain.model.GoodDomainModel
import com.example.rxctakehome.domain.model.LikeDomainModel

data class GoodPresentationModel(
    val brandName: String,
    val discountRate: Double,
    val consumerPrice: Int,
    val name: String,
    val price: Int,
    val thumbnailUrl: String,
    val isLiked: Boolean = false,
) {
    fun toDomainModel(): LikeDomainModel {
        return LikeDomainModel(
            brandName = brandName,
            discountRate = discountRate,
            consumerPrice = consumerPrice,
            name = name,
            price = price,
            thumbnailUrl = thumbnailUrl,
        )
    }

    companion object {
        operator fun invoke(model: GoodDomainModel) = GoodPresentationModel(
            brandName = model.brandName ?: "",
            discountRate = model.discountRate ?: 0.0,
            consumerPrice = model.consumerPrice ?: 0,
            name = model.name ?: "",
            price = model.price ?: 0,
            thumbnailUrl = model.thumbnailUrl ?: "",
        )

        operator fun invoke(modelList: List<GoodDomainModel>) = modelList.map { GoodPresentationModel(it) }

        val diffUtil = object : DiffUtil.ItemCallback<GoodPresentationModel>() {
            override fun areItemsTheSame(oldItem: GoodPresentationModel, newItem: GoodPresentationModel): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(oldItem: GoodPresentationModel, newItem: GoodPresentationModel): Boolean {
                return oldItem == newItem
            }
        }
    }
}
