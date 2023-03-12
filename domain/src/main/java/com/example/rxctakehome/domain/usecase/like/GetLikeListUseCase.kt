package com.example.rxctakehome.domain.usecase.like

import com.example.rxctakehome.data.repository.LikeRepository
import com.example.rxctakehome.domain.model.LikeDomainModel
import com.example.rxctakehome.util.di.Dispatcher
import com.example.rxctakehome.util.di.RXCDispatchers
import dagger.Reusable
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@Reusable
class GetLikeListUseCase @Inject constructor(
    private val likeRepository: LikeRepository,
    @Dispatcher(RXCDispatchers.Io) private val dispatcher: CoroutineDispatcher,
) {
    operator fun invoke(): Flow<List<LikeDomainModel>> {
        return likeRepository.getLikeList()
            .map { likeList -> LikeDomainModel(likeList) }
            .flowOn(dispatcher)
    }
}
