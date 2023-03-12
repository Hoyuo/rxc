package com.example.rxctakehome.domain.usecase.like

import com.example.rxctakehome.data.repository.LikeRepository
import com.example.rxctakehome.domain.model.LikeDomainModel
import com.example.rxctakehome.util.di.Dispatcher
import com.example.rxctakehome.util.di.RXCDispatchers
import com.example.rxctakehome.util.usecase.CoroutineUseCase
import dagger.Reusable
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

@Reusable
class RemoveLikeItemUseCase @Inject constructor(
    private val likeRepository: LikeRepository,
    @Dispatcher(RXCDispatchers.Io) dispatcher: CoroutineDispatcher,
) : CoroutineUseCase<LikeDomainModel, Unit>(dispatcher) {

    override suspend fun execute(parameters: LikeDomainModel) {
        likeRepository.removeLike(parameters.toDataModel())
    }
}
