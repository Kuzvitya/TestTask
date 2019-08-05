package com.example.testtask.tools.listbuilder

import androidx.recyclerview.widget.RecyclerView

class AdapterList<T> {

    val list: ArrayList<T> = arrayListOf()

    var adapter: RecyclerView.Adapter<*>? = null

    fun addList(items: List<T>) {
        list.clear()
        list.addAll(items)
        update()
    }

    private fun update() {
        adapter?.notifyDataSetChanged()
    }
}