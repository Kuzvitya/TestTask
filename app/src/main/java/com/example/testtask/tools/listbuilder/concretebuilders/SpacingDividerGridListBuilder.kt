package com.example.testtask.tools.listbuilder.concretebuilders

import android.content.Context
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testtask.tools.listbuilder.AbstractListBuilder
import com.example.testtask.tools.listbuilder.decorators.ItemSpaceDecoration

class SpacingDividerGridListBuilder(
    private val spanCount: Int,
    private val spanSpacing: Int) : AbstractListBuilder {

    override fun getDivider(): RecyclerView.ItemDecoration? {
        return ItemSpaceDecoration(spanSpacing)
    }

    override fun getLayoutManager(context: Context): RecyclerView.LayoutManager {
        return GridLayoutManager(context, spanCount)
    }
}