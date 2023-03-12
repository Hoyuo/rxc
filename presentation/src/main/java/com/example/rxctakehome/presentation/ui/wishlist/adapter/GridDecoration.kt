package com.example.rxctakehome.presentation.ui.wishlist.adapter

import android.graphics.Rect
import android.view.View
import androidx.annotation.Px
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class GridDecoration(
    private val spanCount: Int,
    @Px private val horizontalSpace: Float,
    @Px private val widthSpace: Float,
    @Px private val heightSpace: Float,
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)

        val lp = view.layoutParams as? GridLayoutManager.LayoutParams

        when (lp?.spanIndex) {
            null -> Unit
            0 -> {
                outRect.left = horizontalSpace.toInt()
                outRect.right = (widthSpace / spanCount).toInt()
            }
            spanCount - 1 -> {
                outRect.left = (widthSpace / spanCount).toInt()
                outRect.right = horizontalSpace.toInt()
            }
            else -> {
                outRect.left = (widthSpace / spanCount).toInt()
                outRect.right = (widthSpace / spanCount).toInt()
            }
        }

        if ((parent.getChildAdapterPosition(view) / spanCount) + 1 != ((state.itemCount + 1) / spanCount)) {
            outRect.bottom = heightSpace.toInt()
        }
    }
}
