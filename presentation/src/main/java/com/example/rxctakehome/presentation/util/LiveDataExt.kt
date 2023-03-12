package com.example.rxctakehome.presentation.util

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData

val LiveData<Boolean>.valueOrDefault: Boolean
    get() {
        return value ?: false
    }

val LiveData<Byte>.valueOrDefault: Byte
    get() {
        return value ?: 0
    }

val LiveData<Char>.valueOrDefault: Char
    get() {
        return value ?: '\u0000'
    }

val LiveData<Double>.valueOrDefault: Double
    get() {
        return value ?: 0.0
    }

val LiveData<Float>.valueOrDefault: Float
    get() {
        return value ?: 0.0f
    }

val LiveData<Int>.valueOrDefault: Int
    get() {
        return value ?: 0
    }

val LiveData<Long>.valueOrDefault: Long
    get() {
        return value ?: 0L
    }

val LiveData<Short>.valueOrDefault: Short
    get() {
        return value ?: 0
    }

val LiveData<String>.valueOrDefault: String
    get() {
        return value ?: ""
    }

val LiveData<out List<*>>.size: Int
    get() {
        return value?.size ?: 0
    }

val <T> LiveData<out List<T>>.list: List<T>
    get() {
        return value ?: emptyList()
    }

operator fun <T> LiveData<out List<T>>.get(index: Int): T? {
    return this.value?.get(index)
}

fun <T> LiveData<Event<T>>.eventObserve(
    owner: LifecycleOwner,
    onEventUnhandledContent: (T) -> Unit,
) {
    this.observe(owner, EventObserver(onEventUnhandledContent))
}

fun <T, K, R> combineWith(
    liveDataSource1: LiveData<T>,
    liveDataSource2: LiveData<K>,
    block: (T?, K?) -> R,
): LiveData<R> {
    val result = MediatorLiveData<R>()
    result.addSource(liveDataSource1) {
        result.value = block(liveDataSource1.value, liveDataSource2.value)
    }
    result.addSource(liveDataSource2) {
        result.value = block(liveDataSource1.value, liveDataSource2.value)
    }
    return result
}

fun <T, K, L, R> combineWith(
    liveDataSource1: LiveData<T>,
    liveDataSource2: LiveData<K>,
    liveDataSource3: LiveData<L>,
    block: (T?, K?, L?) -> R,
): LiveData<R> {
    val result = MediatorLiveData<R>()
    result.addSource(liveDataSource1) {
        result.value = block(liveDataSource1.value, liveDataSource2.value, liveDataSource3.value)
    }
    result.addSource(liveDataSource2) {
        result.value = block(liveDataSource1.value, liveDataSource2.value, liveDataSource3.value)
    }
    result.addSource(liveDataSource3) {
        result.value = block(liveDataSource1.value, liveDataSource2.value, liveDataSource3.value)
    }
    return result
}

fun <T, K, L, Q, R> combineWith(
    liveDataSource1: LiveData<T>,
    liveDataSource2: LiveData<K>,
    liveDataSource3: LiveData<L>,
    liveDataSource4: LiveData<Q>,
    block: (T?, K?, L?, Q?) -> R,
): LiveData<R> {
    val result = MediatorLiveData<R>()
    result.addSource(liveDataSource1) {
        result.value = block(liveDataSource1.value, liveDataSource2.value, liveDataSource3.value, liveDataSource4.value)
    }
    result.addSource(liveDataSource2) {
        result.value = block(liveDataSource1.value, liveDataSource2.value, liveDataSource3.value, liveDataSource4.value)
    }
    result.addSource(liveDataSource3) {
        result.value = block(liveDataSource1.value, liveDataSource2.value, liveDataSource3.value, liveDataSource4.value)
    }
    result.addSource(liveDataSource4) {
        result.value = block(liveDataSource1.value, liveDataSource2.value, liveDataSource3.value, liveDataSource4.value)
    }
    return result
}

fun <A, B, C, D, E, R> combineWith(
    liveDataSource1: LiveData<A>,
    liveDataSource2: LiveData<B>,
    liveDataSource3: LiveData<C>,
    liveDataSource4: LiveData<D>,
    liveDataSource5: LiveData<E>,
    block: (A?, B?, C?, D?, E?) -> R,
): LiveData<R> {
    val result = MediatorLiveData<R>()
    result.addSource(liveDataSource1) {
        result.value =
            block(liveDataSource1.value, liveDataSource2.value, liveDataSource3.value, liveDataSource4.value, liveDataSource5.value)
    }
    result.addSource(liveDataSource2) {
        result.value =
            block(liveDataSource1.value, liveDataSource2.value, liveDataSource3.value, liveDataSource4.value, liveDataSource5.value)
    }
    result.addSource(liveDataSource3) {
        result.value =
            block(liveDataSource1.value, liveDataSource2.value, liveDataSource3.value, liveDataSource4.value, liveDataSource5.value)
    }
    result.addSource(liveDataSource4) {
        result.value =
            block(liveDataSource1.value, liveDataSource2.value, liveDataSource3.value, liveDataSource4.value, liveDataSource5.value)
    }
    result.addSource(liveDataSource5) {
        result.value =
            block(liveDataSource1.value, liveDataSource2.value, liveDataSource3.value, liveDataSource4.value, liveDataSource5.value)
    }
    return result
}
