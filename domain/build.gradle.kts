plugins {
    com.android.library
    `kotlin-android`
    `kotlin-kapt`
}

android {
    namespace = "com.example.rxctakehome.domain"
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
    implementation(project(":data"))

    kotlinImplementation()
    hiltImplementation()
}
