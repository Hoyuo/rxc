object Dependency {
    object GradlePlugin {
        const val build =
            "com.android.tools.build:gradle:${Versions.buildGradle}"
        const val kotlin =
            "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
        const val kotlin_serialization =
            "org.jetbrains.kotlin:kotlin-serialization:${Versions.kotlin}"
        const val hilt =
            "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}"
        const val ktlint =
            "org.jlleitschuh.gradle:ktlint-gradle:${Versions.ktLint}"
        const val protobuf =
            "com.google.protobuf:protobuf-gradle-plugin:${Versions.protobufGradle}"
    }

    object Kotlin {
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"

        object Coroutines {
            const val core =
                "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
            const val android =
                "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
            const val playService =
                "org.jetbrains.kotlinx:kotlinx-coroutines-play-services:${Versions.coroutines}"
        }

        object Ktor {
            const val core =
                "io.ktor:ktor-client-core:${Versions.ktor}"
            const val okhttp =
                "io.ktor:ktor-client-okhttp:${Versions.ktor}"
            const val logging =
                "io.ktor:ktor-client-logging:${Versions.ktor}"
        }

        object Serialization {
            const val core =
                "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.serialization}"

            const val json =
                "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.serialization}"
        }

        object Test {
            const val junit =
                "org.jetbrains.kotlin:kotlin-test-junit:${Versions.kotlin}"
        }

        fun list() = listOf(
            stdlib,
            Coroutines.core,
            Coroutines.android,
            Coroutines.playService,
            Ktor.core,
            Ktor.okhttp,
            Ktor.logging,
            Serialization.core,
            Serialization.json
        )
    }

    object AndroidX {
        const val core =
            "androidx.core:core-ktx:${Versions.core}"
        const val appcompat =
            "androidx.appcompat:appcompat:${Versions.appcompat}"
        const val material =
            "com.google.android.material:material:${Versions.material}"
        const val annotation =
            "androidx.annotation:annotation:${Versions.annotation}"
        const val recyclerview =
            "androidx.recyclerview:recyclerview:${Versions.recyclerview}"
        const val paging3 =
            "androidx.paging:paging-runtime-ktx:${Versions.paging}"
        const val swiperefreshlayout =
            "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.swipeRefreshLayout}"
        const val constraintlayout =
            "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
        const val activity =
            "androidx.activity:activity-ktx:${Versions.activity}"
        const val fragment =
            "androidx.fragment:fragment-ktx:${Versions.fragment}"
        const val startup =
            "androidx.startup:startup-runtime:${Versions.startup}"

        fun list() = listOf(
            core,
            appcompat,
            material,
            annotation,
            recyclerview,
            paging3,
            swiperefreshlayout,
            constraintlayout,
            activity,
            fragment,
            startup
        )

        object Lifecycle {
            const val viewModel =
                "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
            const val liveData =
                "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
            const val saveSate =
                "androidx.lifecycle:lifecycle-viewmodel-savedstate:${Versions.lifecycle}"
            const val java8 =
                "androidx.lifecycle:lifecycle-common-java8:${Versions.lifecycle}"

            fun list() = listOf(
                viewModel,
                liveData,
                saveSate,
                java8
            )
        }

        object DataStore {
            const val core =
                "androidx.datastore:datastore:${Versions.datastore}"

            fun list() = listOf(
                core
            )
        }

        object Room {
            const val runtime =
                "androidx.room:room-runtime:${Versions.room}"
            const val compiler =
                "androidx.room:room-compiler:${Versions.room}"
            const val ktx =
                "androidx.room:room-ktx:${Versions.room}"
        }

        object WorkManager {
            const val runtime =
                "androidx.work:work-runtime-ktx:${Versions.work}"
            const val testing =
                "androidx.work:work-testing:${Versions.work}"
        }
    }

    object Hilt {
        const val hilt =
            "com.google.dagger:hilt-android:${Versions.hilt}"
        const val compiler =
            "com.google.dagger:hilt-android-compiler:${Versions.hilt}"

        const val work =
            "androidx.hilt:hilt-work:${Versions.hiltWork}"
        const val workCompiler =
            "androidx.hilt:hilt-compiler:${Versions.hiltWork}"
    }

    object Flipper {
        const val flipper =
            "com.facebook.flipper:flipper:${Versions.flipper}"
        const val network =
            "com.facebook.flipper:flipper-network-plugin:${Versions.flipper}"
        const val canary2 =
            "com.facebook.flipper:flipper-leakcanary2-plugin:${Versions.flipper}"
        const val soloader =
            "com.facebook.soloader:soloader:${Versions.soLoader}"

        fun list() = listOf(
            flipper,
            network,
            canary2,
            soloader
        )
    }

    const val canary2 =
        "com.squareup.leakcanary:leakcanary-android:${Versions.canary}"

    const val timber =
        "com.jakewharton.timber:timber:${Versions.timber}"

    object OkHttp3 {
        const val okhttp =
            "com.squareup.okhttp3:okhttp:${Versions.okhttp3}"
        const val logging =
            "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp3}"
    }

    object Retrofit2 {
        const val retrofit =
            "com.squareup.retrofit2:retrofit:${Versions.retrofit2}"
        const val moshi =
            "com.squareup.retrofit2:converter-moshi:${Versions.retrofit2}"
        const val scalars =
            "com.squareup.retrofit2:converter-scalars:${Versions.retrofit2}"
    }

    object Moshi {
        const val kotlin =
            "com.squareup.moshi:moshi-kotlin:${Versions.moshi}"

        const val codegen =
            "com.squareup.moshi:moshi-kotlin-codegen:${Versions.moshi}"

        const val adapter =
            "com.squareup.moshi:moshi-adapters:${Versions.moshi}"
    }

    const val protoKotlin =
        "com.google.protobuf:protobuf-kotlin-lite:${Versions.protobufKotlin}"

    object Glide {
        const val glide =
            "com.github.bumptech.glide:glide:${Versions.glide}"
        const val annotation =
            "com.github.bumptech.glide:annotations:${Versions.glide}"
        const val compiler =
            "com.github.bumptech.glide:compiler:${Versions.glide}"
        const val transformations =
            "jp.wasabeef:glide-transformations:4.3.0"
        const val transformations_gpu =
            "jp.co.cyberagent.android:gpuimage:2.1.0"
    }

    object Coil {
        const val base =
            "io.coil-kt:coil:${Versions.coil}"
        const val svg =
            "io.coil-kt:coil-svg:${Versions.coil}"
        const val gif =
            "io.coil-kt:coil-gif:${Versions.coil}"
        const val video =
            "io.coil-kt:coil-video:${Versions.coil}"
        const val transformations =
            "com.github.Commit451.coil-transformations:transformations:2.0.2"
        const val transformations_gpu =
            "com.github.Commit451.coil-transformations:transformations-gpu:2.0.2"
    }

    object Lottie {
        const val sdk =
            "com.airbnb.android:lottie:${Versions.lottie}"
    }

    const val threeTen =
        "com.jakewharton.threetenabp:threetenabp:${Versions.threeTen}"

    const val tink =
        "com.google.crypto.tink:tink-android:${Versions.tink}"

    object Test {
        const val hilt =
            "com.google.dagger:hilt-android-testing:${Versions.hilt}"

        object AndroidX {
            const val core =
                "androidx.test:core-ktx:${Versions.Test.core}"
            const val runner =
                "androidx.test:runner:${Versions.Test.runner}"
            const val rules =
                "androidx.test:rules:${Versions.Test.rules}"
            const val truth =
                "androidx.test.ext:truth:${Versions.Test.truth}"
            const val junit =
                "androidx.test.ext:junit-ktx:${Versions.Test.junit}"
            const val orchestrator =
                "androidx.test:orchestrator:${Versions.Test.orchestrator}"
        }

        object Espresso {
            const val core =
                "androidx.test.espresso:espresso-core:${Versions.Test.espresso}"
            const val contrib =
                "androidx.test.espresso:espresso-contrib:${Versions.Test.espresso}"
            const val intents =
                "androidx.test.espresso:espresso-intents:${Versions.Test.espresso}"
            const val accessibility =
                "androidx.test.espresso:espresso-accessibility:${Versions.Test.espresso}"
            const val web =
                "androidx.test.espresso:espresso-web:${Versions.Test.espresso}"
            const val idlingConcurrent =
                "androidx.test.espresso.idling:idling-concurrent:${Versions.Test.espresso}"
            const val idlingResource =
                "androidx.test.espresso:espresso-idling-resource:${Versions.Test.espresso}"
        }

        object Junit {
            const val api =
                "junit:junit:${Versions.Test.junit4}"
        }

        const val uiAutomator =
            "androidx.test.uiautomator:uiautomator:${Versions.Test.uiAutomator}"
        const val mockito =
            "org.mockito:mockito-core:${Versions.Test.mockito}"
    }
}
