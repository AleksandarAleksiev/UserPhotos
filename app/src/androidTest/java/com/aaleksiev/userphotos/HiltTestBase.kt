package com.aaleksiev.userphotos

import android.content.Context
import androidx.annotation.CallSuper
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.rules.ActivityScenarioRule
import dagger.hilt.android.testing.HiltAndroidRule
import org.junit.Before
import org.junit.Rule


abstract class HiltTestBase {
    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @get:Rule
    var activityRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)

    val applicationContext: Context by lazy {
        ApplicationProvider.getApplicationContext()
    }

    @Before
    @CallSuper
    fun setUp() {
        hiltRule.inject()
    }
}