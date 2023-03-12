package com.example.rxctakehome.presentation.ui.wishlist.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.rxctakehome.presentation.model.GoodPresentationModel

class WishListAdapter(
    private val onLikeClicked: (GoodPresentationModel) -> Unit,
) : ListAdapter<GoodPresentationModel, WishItemViewHolder>(GoodPresentationModel.diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WishItemViewHolder {
        return WishItemViewHolder(parent)
    }

    override fun onBindViewHolder(holder: WishItemViewHolder, position: Int) {
        holder.bind(getItem(position), onLikeClicked)
    }
}
