package com.example.rxctakehome.domain.usecase.good

import com.example.rxctakehome.data.repository.GoodRepository
import com.example.rxctakehome.domain.model.GoodDomainModel
import com.example.rxctakehome.util.di.Dispatcher
import com.example.rxctakehome.util.di.RXCDispatchers
import com.example.rxctakehome.util.usecase.ActionFlowUseCase
import dagger.Reusable
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@Reusable
class GetGoodListUseCase @Inject constructor(
    private val goodRepository: GoodRepository,
    private val updateGoodListUseCase: UpdateGoodListUseCase,
    @Dispatcher(RXCDispatchers.Io) dispatcher: CoroutineDispatcher,
) : ActionFlowUseCase<List<GoodDomainModel>>(dispatcher) {
    override fun execute() = goodRepository.getListLocal().map { localGoods ->
        if (localGoods.isNotEmpty()) {
            Result.success(localGoods.map { GoodDomainModel(it) })
        } else {
            updateGoodListUseCase()
            Result.failure(Throwable("Local data not found."))
        }
    }
}
