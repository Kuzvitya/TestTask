package com.example.testtask.tools.listbuilder

import androidx.recyclerview.widget.RecyclerView

class ListBuilderDirector<T> {

    private var builder: AbstractListBuilder? = null

    fun setBuilder(builder: AbstractListBuilder) : ListBuilderDirector<T> {
        this.builder = builder
        return this
    }

    fun build(
        recyclerView: RecyclerView,
        adapterList: AdapterList<T>,
        adapterCreator: (List<T>) -> RecyclerView.Adapter<out RecyclerView.ViewHolder>) {

        builder ?: return
        val adapter = adapterCreator.invoke(adapterList.list)
        adapterList.adapter = adapter
        builder?.build(recyclerView, adapter)
    }

}