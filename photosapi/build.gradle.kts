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

    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }
}

dependencies {

    implementation(project(":core"))

    implementation(Dependencies.Kotlin.stdLib)
    implementation(Dependencies.AndroidX.coreKtx)

    api(Dependencies.Network.retrofit)
    implementation(Dependencies.Network.retrofitJsonConverter)
    implementation(Dependencies.Network.okhttp)
    implementation(Dependencies.Network.okhttpLoggingInterceptor)

    implementation(Dependencies.Json.moshi)
    implementation(Dependencies.Json.moshiAdapters)

    implementation(Dependencies.AndroidX.hilt)
    implementation(Dependencies.RxJava.rxJava)
    implementation(Dependencies.RxJava.rxRetrofitAdapter)

    kapt(Dependencies.Kapt.moshi)
    kapt(Dependencies.Kapt.hilt)

    testImplementation(Dependencies.Test.androidXjUnit)
    testImplementation(Dependencies.Test.androidXTestCore)
    testImplementation(Dependencies.Test.androidXTestRules)
    testImplementation(Dependencies.Test.androidXTestExtTruth)
}