import org.gradle.kotlin.dsl.DependencyHandlerScope

fun DependencyHandlerScope.implementations(argument: List<String>) {
    argument.forEach {
        "implementation"(it)
    }
}

fun DependencyHandlerScope.debugImplementations(argument: List<String>) {
    argument.forEach {
        "debugImplementation"(it)
    }
}

fun DependencyHandlerScope.kotlinImplementation() {
    implementations(Dependency.Kotlin.list())
}

fun DependencyHandlerScope.androidImplementation() {
    implementations(Dependency.AndroidX.list())
}

fun DependencyHandlerScope.androidLifecycleImplementation() {
    implementations(Dependency.AndroidX.Lifecycle.list())
}

fun DependencyHandlerScope.androidRoomImplementation() {
    "implementation"(Dependency.AndroidX.Room.runtime)
    "kapt"(Dependency.AndroidX.Room.compiler)
    "implementation"(Dependency.AndroidX.Room.ktx)
}

fun DependencyHandlerScope.androidDataStoreImplementation() {
    implementations(Dependency.AndroidX.DataStore.list())
}

fun DependencyHandlerScope.androidWorkManagerImplementation() {
    "implementation"(Dependency.AndroidX.WorkManager.runtime)
}

fun DependencyHandlerScope.hiltWorkImplementation() {
    "implementation"(Dependency.Hilt.work)
    "kapt"(Dependency.Hilt.workCompiler)
}

fun DependencyHandlerScope.hiltImplementation() {
    "implementation"(Dependency.Hilt.hilt)
    "kapt"(Dependency.Hilt.compiler)

    "androidTestImplementation"(Dependency.Test.hilt)
    "kaptAndroidTest"(Dependency.Hilt.compiler)

    "testImplementation"(Dependency.Test.hilt)
    "kaptTest"(Dependency.Hilt.compiler)
}

fun DependencyHandlerScope.debugToolsImplementation() {
    debugImplementations(Dependency.Flipper.list())
    debugImplementations(listOf(Dependency.canary2))
}

fun DependencyHandlerScope.networkImplementation() {
    "implementation"(Dependency.OkHttp3.okhttp)
    "implementation"(Dependency.OkHttp3.logging)

    "implementation"(Dependency.Retrofit2.retrofit)
    "implementation"(Dependency.Retrofit2.moshi)
}

fun DependencyHandlerScope.moshiImplementation() {
    "implementation"(Dependency.Moshi.kotlin)
    "kapt"(Dependency.Moshi.codegen)
    "implementation"(Dependency.Moshi.adapter)
}

fun DependencyHandlerScope.imageImplementation() {
    "implementation"(Dependency.Coil.base)
    "implementation"(Dependency.Coil.gif)
    "implementation"(Dependency.Coil.svg)
    "implementation"(Dependency.Coil.video)
    "implementation"(Dependency.Coil.transformations)
    "implementation"(Dependency.Coil.transformations_gpu)

    "implementation"(Dependency.Lottie.sdk)
}

fun DependencyHandlerScope.loggingImplementation() {
    "implementation"(Dependency.timber)
}
