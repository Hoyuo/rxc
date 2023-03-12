package com.example.rxctakehome.data.remote.di

import android.content.Context
import com.example.rxctakehome.util.ktx.appVersion
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RemoteModule {

    const val BASE_URL = "https://mobile-task.rxc.co.kr/"

    @UserInterceptor
    @Provides
    @Singleton
    fun provideInterceptor(
        @ApplicationContext context: Context,
    ): Interceptor { // 토큰이 있으면 헤더에 추가하는 interceptor
        return Interceptor { chain ->
            val userAgent =
                "RXC/${context.appVersion} ${System.getProperty("http.agent")}"

            val req = chain.request().newBuilder().addHeader("User-Agent", userAgent)
            chain.proceed(req.build())
        }
    }

    @Provides
    @Singleton
    fun providesMoshi(): Moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    @Singleton
    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        moshi: Moshi,
    ): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .build()
    }
}
