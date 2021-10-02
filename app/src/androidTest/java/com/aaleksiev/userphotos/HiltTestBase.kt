package com.aaleksiev.userphotos

import android.content.Context
import androidx.annotation.CallSuper
import androidx.test.core.app.ApplicationProvider
import dagger.hilt.android.testing.HiltAndroidRule
import org.junit.Before
import org.junit.Rule


abstract class HiltTestBase {
    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @get:Rule
    val rxJavaRule = TestSchedulerRule()

    val applicationContext: Context by lazy {
        ApplicationProvider.getApplicationContext()
    }

    @Before
    @CallSuper
    open fun setUp() {
        hiltRule.inject()
    }
}