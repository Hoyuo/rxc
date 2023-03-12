import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jlleitschuh.gradle.ktlint.KtlintExtension
import org.jlleitschuh.gradle.ktlint.tasks.BaseKtLintCheckTask

buildscript {
    repositories {
        google()
        mavenCentral()
        maven("https://jcenter.bintray.com/")
    }

    dependencies {
        classpath(Dependency.GradlePlugin.build)
        classpath(Dependency.GradlePlugin.kotlin)
        classpath(Dependency.GradlePlugin.ktlint)
        classpath(Dependency.GradlePlugin.hilt)
    }
}

plugins {
    id("org.jlleitschuh.gradle.ktlint") version Versions.ktLint
}

allprojects {
    repositories {
        google()
        mavenCentral()
        mavenLocal()
        maven("https://jcenter.bintray.com/")
        maven("https://jitpack.io")
        maven("https://plugins.gradle.org/m2/")
    }

    apply(plugin = "org.jlleitschuh.gradle.ktlint")

    configure<KtlintExtension> {
        outputColorName.set("RED")
        if (this@allprojects.isAndroidProject) {
            android.set(true)
        }
    }
    tasks.withType<BaseKtLintCheckTask> {
        workerMaxHeapSize.set("1g")
    }

    tasks {
        withType<KotlinCompile> {
            kotlinOptions {
                jvmTarget = JavaVersion.VERSION_11.toString()
                freeCompilerArgs = listOf("-opt-in=kotlin.RequiresOptIn")
            }
        }
    }
}

tasks {
    register("clean", Delete::class) {
        delete(rootProject.buildDir)
    }
}
