package com.example.rxctakehome.presentation.ui.wishlist

import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.rxctakehome.domain.usecase.good.GetGoodListUseCase
import com.example.rxctakehome.domain.usecase.like.AddLikeItemUseCase
import com.example.rxctakehome.domain.usecase.like.GetLikeListUseCase
import com.example.rxctakehome.domain.usecase.like.RemoveLikeItemUseCase
import com.example.rxctakehome.presentation.base.BaseViewModel
import com.example.rxctakehome.presentation.model.GoodPresentationModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WishListViewModel @Inject constructor(
    getGoodListUseCase: GetGoodListUseCase,
    getLikeListUseCase: GetLikeListUseCase,
    private val addLikeItemUseCase: AddLikeItemUseCase,
    private val removeLikeItemUseCase: RemoveLikeItemUseCase,
) : BaseViewModel<WishListEvent>() {

    private val list = getGoodListUseCase()
        .map {
            it.fold(
                onSuccess = { GoodPresentationModel(it) },
                onFailure = { emptyList() }
            )
        }

    private val like = getLikeListUseCase()

    val likedList = combine(list, like) { list, like ->
        list.map { good ->
            good.copy(isLiked = like.any { it.name == good.name && it.brandName == good.brandName })
        }
    }.asLiveData()

    fun onLikeClicked(good: GoodPresentationModel) {
        viewModelScope.launch {
            if (good.isLiked) {
                removeLikeItemUseCase(good.toDomainModel())
            } else {
                addLikeItemUseCase(good.toDomainModel())
            }
        }
    }
}
