package com.aaleksiev.userphotos.photos

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.aaleksiev.userphotos.MainActivity
import com.aaleksiev.userphotos.R
import com.aaleksiev.userphotos.matchers.viewWithItemMatcher
import com.aaleksiev.userphotos.robot.BaseRobot

class PhotosRobot : BaseRobot() {
    fun photoWithTitleIsDisplayed(title: String) {
        onView(withId(R.id.photos_list))
            .check(matches(viewWithItemMatcher(R.id.title, withText(title))))
    }

    fun errorIsDisplayed() {
        issDisplayed(R.id.error_title)
        issDisplayed(R.id.error_message)
    }
}

fun userPhotos(block: PhotosRobot.() -> Unit) {
    ActivityScenario.launch(MainActivity::class.java)
    PhotosRobot().apply(block)
}