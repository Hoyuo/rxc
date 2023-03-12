plugins {
    com.android.application
    `kotlin-android`
    `kotlin-kapt`
    `kotlin-serialization`
    `hilt-plugin`
}

kapt {
    correctErrorTypes = true
}

android {
    namespace = "com.example.rxctakehome"
    compileSdk = Versions.compileSdk

    defaultConfig {
        applicationId = "com.example.rxctakehome"
        minSdk = Versions.minSdk
        targetSdk = Versions.targetSdk
        versionCode = AppVersions.versionCode
        versionName = AppVersions.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        debug {
            isMinifyEnabled = false
            isDebuggable = true
            versionNameSuffix = "-debug"
        }
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            isDebuggable = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    flavorDimensions += "api"
    productFlavors {
        create("dev") {
            dimension = "api"
            versionNameSuffix = "-dev"
        }
        create("prod") {
            dimension = "api"
        }
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

    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

hilt {
    enableAggregatingTask = false
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":data"))
    implementation(project(":data:local"))
    implementation(project(":data:remote"))
    implementation(project(":presentation"))
    implementation(project(":util"))

    kotlinImplementation()

    androidImplementation()
    androidLifecycleImplementation()
    androidRoomImplementation()
    androidDataStoreImplementation()

    hiltImplementation()

    debugToolsImplementation()

    networkImplementation()
    moshiImplementation()

    imageImplementation()

    loggingImplementation()

    implementation(Dependency.threeTen)

    implementation(Dependency.tink)
}
