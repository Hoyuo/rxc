package com.example.rxctakehome.util.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Dispatcher(val dispatchers: RXCDispatchers)

enum class RXCDispatchers {
    Default, Io, Main, MainImmediate
}
