plugins {
    com.android.library
    `kotlin-android`
    `kotlin-kapt`
    `kotlin-serialization`
}

android {
    namespace = "com.example.rxctakehome.data.remote"
    compileSdk = Versions.compileSdk

    defaultConfig {
        minSdk = Versions.minSdk
        targetSdk = Versions.targetSdk
    }

    buildFeatures {
        resValues = false
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }

    flavorDimensions += "api"

    productFlavors {
        create("dev") {
            dimension = "api"
        }
        create("prod") {
            dimension = "api"
        }
    }
}

dependencies {
    implementation(project(":util"))

    kotlinImplementation()
    networkImplementation()
    moshiImplementation()
    debugToolsImplementation()
    hiltImplementation()
}
