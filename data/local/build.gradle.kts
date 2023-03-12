plugins {
    com.android.library
    `kotlin-android`
    `kotlin-kapt`
    `kotlin-serialization`
}

android {
    namespace = "com.example.rxctakehome.data.local"
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
}

dependencies {
    implementation(project(":util"))

    kotlinImplementation()
    androidRoomImplementation()
    hiltImplementation()
}
