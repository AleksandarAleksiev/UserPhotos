package com.aaleksiev.userphotos.robot

import androidx.annotation.IdRes
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*

abstract class BaseRobot {

    fun textView(@IdRes resId: Int): ViewInteraction = onView(withId(resId))

    fun matchText(viewInteraction: ViewInteraction, text: String): ViewInteraction = viewInteraction
        .check(matches(withText(text)))

    fun matchText(@IdRes resId: Int, text: String): ViewInteraction =
        matchText(textView(resId), text)

    fun issDisplayed(@IdRes resId: Int) = onView(withId(resId)).check(matches(isDisplayed()))
}