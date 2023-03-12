package com.example.rxctakehome.presentation.ui.wishlist

import androidx.fragment.app.viewModels
import com.example.rxctakehome.presentation.BR
import com.example.rxctakehome.presentation.R
import com.example.rxctakehome.presentation.base.BaseFragment
import com.example.rxctakehome.presentation.databinding.FragmentWishlistBinding
import com.example.rxctakehome.presentation.ui.wishlist.adapter.GridDecoration
import com.example.rxctakehome.presentation.ui.wishlist.adapter.WishListAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WishListFragment : BaseFragment<FragmentWishlistBinding, WishListViewModel, WishListEvent>(FragmentWishlistBinding::inflate) {
    override val viewModel: WishListViewModel by viewModels()

    override fun viewModelVariableId(): Int = BR.vm

    override fun bindLayout() {
        bind {
            list.adapter = WishListAdapter {
                viewModel.onLikeClicked(it)
            }
            list.addItemDecoration(
                GridDecoration(
                    spanCount = resources.getInteger(R.integer.recycler_view_span_count),
                    horizontalSpace = resources.getDimension(R.dimen.recycler_view_horizontal_space),
                    widthSpace = resources.getDimension(R.dimen.recycler_view_width_space),
                    heightSpace = resources.getDimension(R.dimen.recycler_view_height_space)
                )
            )
            list.itemAnimator = null
        }
    }
}
