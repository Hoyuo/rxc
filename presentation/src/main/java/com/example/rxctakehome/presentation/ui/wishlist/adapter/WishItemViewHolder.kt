package com.example.rxctakehome.presentation.ui.wishlist.adapter

import android.view.ViewGroup
import com.example.rxctakehome.presentation.base.BaseViewHolder
import com.example.rxctakehome.presentation.databinding.ItemViewBinding
import com.example.rxctakehome.presentation.model.GoodPresentationModel
import com.example.rxctakehome.util.ktx.layoutInflater
import com.example.rxctakehome.util.ktx.setImage

class WishItemViewHolder(
    private val binding: ItemViewBinding,
) : BaseViewHolder(binding.root) {

    fun bind(item: GoodPresentationModel, onLikeClicked: (GoodPresentationModel) -> Unit) {
        with(binding) {
            this.item = item
            this.image.setImage(item.thumbnailUrl)
            this.like.setOnClickListener { onLikeClicked(item) }
            executePendingBindings()
        }
    }

    companion object {
        operator fun invoke(parent: ViewGroup): WishItemViewHolder {
            val binding = ItemViewBinding.inflate(
                parent.layoutInflater,
                parent,
                false
            )
            return WishItemViewHolder(binding)
        }
    }
}
