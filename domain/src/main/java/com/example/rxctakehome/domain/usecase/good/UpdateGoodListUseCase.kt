package com.example.rxctakehome.domain.usecase.good

import com.example.rxctakehome.data.repository.GoodRepository
import dagger.Reusable
import javax.inject.Inject

@Reusable
class UpdateGoodListUseCase @Inject constructor(
    private val goodRepository: GoodRepository,
) {
    suspend operator fun invoke() {
        val list = goodRepository.getListRemote()
        if (list.isNotEmpty()) {
            goodRepository.insert(list)
        }
    }
}
