package com.example.rxctakehome.presentation.base

import androidx.lifecycle.ViewModel
import com.example.rxctakehome.presentation.util.EventLiveData
import com.example.rxctakehome.presentation.util.EventMutableLiveData

abstract class BaseViewModel<E : BaseEvent> : ViewModel() {

    private val _event = EventMutableLiveData<E>()
    val event: EventLiveData<E> = _event

    open fun updateEvent(event: E) {
        _event.setValue(event)
    }
}
