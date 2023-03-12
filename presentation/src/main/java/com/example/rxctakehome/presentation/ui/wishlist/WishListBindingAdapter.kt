package com.example.rxctakehome.presentation.ui.wishlist

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.rxctakehome.presentation.model.GoodPresentationModel
import com.example.rxctakehome.presentation.ui.wishlist.adapter.WishListAdapter

@BindingAdapter("bind:list")
fun RecyclerView.setList(list: List<GoodPresentationModel>?) {
    (adapter as? WishListAdapter)?.submitList(list ?: emptyList())
}
