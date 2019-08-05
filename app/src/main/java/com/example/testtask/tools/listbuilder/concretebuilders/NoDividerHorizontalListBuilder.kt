package com.example.testtask.tools.listbuilder.concretebuilders

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testtask.tools.listbuilder.AbstractListBuilder

class NoDividerHorizontalListBuilder : AbstractListBuilder {

    override fun getLayoutManager(context: Context): RecyclerView.LayoutManager {
        return LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
    }
}