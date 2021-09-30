plugins {
    id(Plugins.androidLibrary)
    id(Plugins.kotlin)
    id(Plugins.kotlinKapt)
    id(Plugins.hilt)
}

android {
    compileSdk = AppConfig.targetSdk
    buildToolsVersion = AppConfig.buildToolsVersion

    defaultConfig {
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk

        vectorDrawables {
            useSupportLibrary = true
        }

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(Dependencies.Kotlin.stdLib)
    implementation(Dependencies.AndroidX.coreKtx)
    implementation(Dependencies.AndroidX.lifecycleCommon)

    implementation(Dependencies.AndroidX.hilt)

    kapt(Dependencies.Kapt.hilt)

    testImplementation(Dependencies.Test.jUnit)
    androidTestImplementation(Dependencies.Test.androidXjUnit)
    androidTestImplementation(Dependencies.Test.espressoCore)
}