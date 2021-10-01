package com.aaleksiev.core.ui

import android.graphics.Rect
import android.view.View
import androidx.annotation.DimenRes
import androidx.recyclerview.widget.RecyclerView
import com.aaleksiev.core.extensions.orZero

class MarginItemDecorator(
    @DimenRes private val firstItemMarginTop: Int? = null,
    @DimenRes private val lastItemMarginBottom: Int? = null,
    @DimenRes private val firstItemMarginStart: Int? = null,
    @DimenRes private val lastItemMarginEnd: Int? = null,
    @DimenRes private val itemMarginStart: Int? = null,
    @DimenRes private val itemMarginEnd: Int? = null,
    @DimenRes private val itemMarginTop: Int? = null,
    @DimenRes private val itemMarginBottom: Int? = null
) : RecyclerView.ItemDecoration() {

    private fun View.dimensToPx(@DimenRes dimens: Int?) = dimens?.let { context.resources.getDimensionPixelOffset(it) } ?: 0

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)

        val position = parent.getChildAdapterPosition(view)
        val totalItems = parent.adapter?.itemCount.orZero()
        if (position == RecyclerView.NO_POSITION || totalItems == 0) {
            return
        }

        outRect.apply {
            top = when (position) {
                0 -> view.dimensToPx(firstItemMarginTop)
                else -> view.dimensToPx(itemMarginTop)
            }
            left = when (position) {
                0 -> view.dimensToPx(firstItemMarginStart)
                else -> view.dimensToPx(itemMarginStart)
            }
            right = when (position) {
                totalItems - 1 -> view.dimensToPx(lastItemMarginEnd)
                else -> view.dimensToPx(itemMarginEnd)
            }
            bottom = when (position) {
                totalItems - 1 -> view.dimensToPx(lastItemMarginBottom)
                else -> view.dimensToPx(itemMarginBottom)
            }
        }
    }
}