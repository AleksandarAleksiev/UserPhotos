object Plugins {
    const val androidGradle = "com.android.tools.build:gradle:${Versions.Plugins.agpVersion}"
    const val kotlinGradle =
        "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.Kotlin.kotlinVersion}"
    const val hiltGradle =
        "com.google.dagger:hilt-android-gradle-plugin:${Versions.AndroidX.hiltVersion}"
    const val hilt = "dagger.hilt.android.plugin"
    const val androidApplication = "com.android.application"
    const val androidLibrary = "com.android.library"
    const val kotlin = "kotlin-android"
    const val kotlinKapt = "kotlin-kapt"
}