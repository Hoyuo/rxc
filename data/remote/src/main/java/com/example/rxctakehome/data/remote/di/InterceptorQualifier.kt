package com.example.rxctakehome.data.remote.di

import javax.inject.Qualifier

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class UserInterceptor

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class LogInterceptor
