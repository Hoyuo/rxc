package com.example.rxctakehome.util.usecase

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn

abstract class ActionFlowUseCase<R>(private val coroutineDispatcher: CoroutineDispatcher) {
    operator fun invoke(): Flow<Result<R>> = execute()
        .catch { e -> emit(Result.failure(e)) }
        .flowOn(coroutineDispatcher)

    protected abstract fun execute(): Flow<Result<R>>
}
