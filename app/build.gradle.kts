plugins {
    id(Plugins.androidApplication)
    id(Plugins.kotlin)
    id(Plugins.kotlinKapt)
    id(Plugins.hilt)
}

android {
    compileSdk = AppConfig.targetSdk
    buildToolsVersion = AppConfig.buildToolsVersion

    defaultConfig {
        applicationId = "com.aaleksiev.creditscore"
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = 1
        versionName = "1.0"

        vectorDrawables {
            useSupportLibrary = true
        }

        testInstrumentationRunner = "com.aaleksiev.creditscore.TestApplicationRunner"

        buildConfigField(
            "String",
            "API_ENDPOINT",
            "\"https://jsonplaceholder.typicode.com/\""
        )
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

    implementation(project(":core"))
    implementation(project(":photosapi"))

    implementation(Dependencies.Kotlin.stdLib)
    implementation(Dependencies.AndroidX.coreKtx)
    implementation(Dependencies.AndroidX.constraintLayout)
    implementation(Dependencies.AndroidX.fragment)
    implementation(Dependencies.MaterialDesign.material)
    implementation(Dependencies.AndroidX.navigationFragment)
    implementation(Dependencies.AndroidX.lifecycleRuntime)
    implementation(Dependencies.AndroidX.lifecycleViewModel)
    implementation(Dependencies.AndroidX.lifecycleLiveData)
    implementation(Dependencies.AndroidX.recyclerView)
    implementation(Dependencies.RxJava.rxJava)

    implementation(Dependencies.AndroidX.hilt)

    kapt(Dependencies.Kapt.hilt)
    kapt(Dependencies.Kapt.lifecycle)

    testImplementation(Dependencies.Test.mockitoInline)
    testImplementation(Dependencies.Test.androidXArchCore)
    testImplementation(Dependencies.Test.androidXjUnit)
    testImplementation(Dependencies.Test.androidXTestCore)
    testImplementation(Dependencies.Test.androidXTestExtTruth)

    androidTestImplementation(Dependencies.Test.mockitoAndroid)
    androidTestImplementation(Dependencies.Test.androidXjUnit)
    androidTestImplementation(Dependencies.Test.androidXTestRules)
    androidTestImplementation(Dependencies.Test.androidXTestRunner)
    androidTestImplementation(Dependencies.Test.espressoCore)
    androidTestImplementation(Dependencies.Test.hilt)

    kaptAndroidTest(Dependencies.Kapt.hilt)
}

kapt {
    correctErrorTypes = true
}