package com.aaleksiev.userphotos.robot

import androidx.annotation.IdRes
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId

abstract class BaseRobot {
    fun isDisplayed(@IdRes resId: Int) = onView(withId(resId)).check(matches(isDisplayed()))
}