package com.example.testtask.tools.listbuilder

import android.content.Context
import androidx.recyclerview.widget.RecyclerView

interface AbstractListBuilder {

    fun getDivider() : RecyclerView.ItemDecoration? = null

    fun getLayoutManager(context: Context) : RecyclerView.LayoutManager

    fun build(recyclerView: RecyclerView, adapter: RecyclerView.Adapter<out RecyclerView.ViewHolder>) {
        recyclerView.layoutManager = getLayoutManager(recyclerView.context)
        getDivider()?.let {
            recyclerView.addItemDecoration(it)
        }
        recyclerView.adapter = adapter
    }


}