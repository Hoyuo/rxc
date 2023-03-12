import org.gradle.kotlin.dsl.kotlin
import org.gradle.plugin.use.PluginDependenciesSpec
import org.gradle.plugin.use.PluginDependencySpec

inline val PluginDependenciesSpec.`kotlin-android`: PluginDependencySpec
    get() = kotlin("android")

inline val PluginDependenciesSpec.`kotlin-kapt`: PluginDependencySpec
    get() = kotlin("kapt")

inline val PluginDependenciesSpec.`kotlin-jvm`: PluginDependencySpec
    get() = kotlin("jvm")

inline val PluginDependenciesSpec.`kotlin-serialization`: PluginDependencySpec
    get() = kotlin("plugin.serialization").version(Versions.kotlin)

inline val PluginDependenciesSpec.ktlint: PluginDependencySpec
    get() = id("org.jlleitschuh.gradle.ktlint")

inline val PluginDependenciesSpec.`hilt-plugin`: PluginDependencySpec
    get() = id("com.google.dagger.hilt.android")

inline val PluginDependenciesSpec.proto: PluginDependencySpec
    get() = id("com.google.protobuf").version(Versions.protobufGradle)
