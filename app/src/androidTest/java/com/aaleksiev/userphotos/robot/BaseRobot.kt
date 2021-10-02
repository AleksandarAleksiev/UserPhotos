package com.aaleksiev.userphotos.robot

import androidx.annotation.IdRes
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import androidx.test.uiautomator.UiDevice

abstract class BaseRobot {
    fun isDisplayed(@IdRes resId: Int): ViewInteraction = onView(withId(resId)).check(matches(isDisplayed()))

    fun rotateDevice() {
        UiDevice.getInstance(getInstrumentation()).setOrientationLeft()
    }
}