plugins {
    com.android.library
    `kotlin-android`
    `kotlin-kapt`
    `hilt-plugin`
}

android {
    namespace = "com.example.rxctakehome.presentation"
    compileSdk = Versions.compileSdk

    defaultConfig {
        minSdk = Versions.minSdk
        targetSdk = Versions.targetSdk
    }

    viewBinding {
        enable = true
    }

    dataBinding {
        enable = true
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
    implementation(project(":domain"))
    implementation(project(":util"))

    kotlinImplementation()

    androidImplementation()
    androidLifecycleImplementation()

    hiltImplementation()

    androidWorkManagerImplementation()
    hiltWorkImplementation()

    loggingImplementation()

    imageImplementation()
}
