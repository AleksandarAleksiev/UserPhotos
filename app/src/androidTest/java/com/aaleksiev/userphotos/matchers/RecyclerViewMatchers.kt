package com.aaleksiev.userphotos.matchers

import android.view.View
import androidx.annotation.IdRes
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.matcher.BoundedMatcher
import com.aaleksiev.core.extensions.orZero
import org.hamcrest.Description
import org.hamcrest.Matcher

fun atPosition(position: Int, @IdRes viewId: Int, itemMatcher: Matcher<View>): Matcher<View> {
    return object : BoundedMatcher<View, RecyclerView>(RecyclerView::class.java) {

        override fun describeTo(description: Description) {
            description.appendText("has item at position $position: ")
            itemMatcher.describeTo(description)
        }

        override fun matchesSafely(view: RecyclerView): Boolean {
            val viewHolder = view.findViewHolderForAdapterPosition(position)
                ?: return false
            return viewHolder.itemView.findViewById<View?>(viewId)?.let {
                itemMatcher.matches(it)
            } ?: false
        }
    }
}

fun viewWithItemMatcher(@IdRes viewId: Int, itemMatcher: Matcher<View>): Matcher<View> {
    return object : BoundedMatcher<View, RecyclerView>(RecyclerView::class.java) {

        override fun describeTo(description: Description) {
            description.appendText("has item with id $viewId ")
            itemMatcher.describeTo(description)
        }

        override fun matchesSafely(view: RecyclerView): Boolean {
            val item = (0 until view.adapter?.itemCount.orZero()).firstOrNull { matchItem(view, it) }
            return item != null
        }

        private fun matchItem(view: RecyclerView, position: Int): Boolean {
            val viewHolder = view.findViewHolderForAdapterPosition(position)
                ?: return false
            return viewHolder.itemView.findViewById<View?>(viewId)?.run {
                itemMatcher.matches(this)
            } ?: false
        }
    }
}