package com.example.rxctakehome.presentation.base

import android.view.View
import androidx.core.view.doOnAttach
import androidx.core.view.doOnDetach
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.findViewTreeLifecycleOwner
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder(
    itemView: View,
) : RecyclerView.ViewHolder(itemView) {
    private var lifecycleOwner: LifecycleOwner? = null

    init {
        itemView.doOnAttach {
            lifecycleOwner = itemView.findViewTreeLifecycleOwner()
        }
        itemView.doOnDetach {
            lifecycleOwner = null
        }
    }
}
