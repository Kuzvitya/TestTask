package com.example.testtask.tools.listbuilder.decorators

import android.graphics.Rect
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.View

class ItemSpaceDecoration(
    private val spacing: Int
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        val position = parent.getChildAdapterPosition(view)
        val totalSpanCount = getTotalSpanCount(parent)
        val spanSize = getItemSpanSize(parent, position)
        if (totalSpanCount == spanSize) {
            return
        }
        outRect.left = if (isFirstInRow(position, totalSpanCount)) 0 else spacing/2
        outRect.top = if (isInTheFirstRow(position, totalSpanCount)) 0 else spacing
        outRect.right = if (isLastInRow(position, totalSpanCount)) 0 else spacing/2
        outRect.bottom = 0
    }

    private fun isInTheFirstRow(position: Int, spanCount: Int) = position < spanCount

    private fun isFirstInRow(position: Int, spanCount: Int) = position % spanCount == 0

    private fun isLastInRow(position: Int, spanCount: Int) = isFirstInRow(position + 1, spanCount)

    private fun getTotalSpanCount(parent: RecyclerView): Int {
        val layoutManager = parent.layoutManager
        return if (layoutManager is GridLayoutManager) {
            layoutManager.spanCount
        } else {
            1
        }
    }

    private fun getItemSpanSize(parent: RecyclerView, position: Int): Int {
        val layoutManager = parent.layoutManager
        return if (layoutManager is GridLayoutManager) {
            layoutManager.spanSizeLookup.getSpanSize(position)
        } else {
            1
        }
    }


}