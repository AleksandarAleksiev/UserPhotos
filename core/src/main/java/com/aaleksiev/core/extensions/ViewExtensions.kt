package com.aaleksiev.core.extensions

import android.widget.ViewSwitcher
import androidx.annotation.IdRes
import androidx.core.view.children

fun ViewSwitcher.displayChild(@IdRes childId: Int) {
    val childIndex = this.children.indexOfFirst { it.id == childId }
    if (childIndex in 0 until childCount) {
        if (displayedChild != childIndex) {
            displayedChild = childIndex
        }
    }
}