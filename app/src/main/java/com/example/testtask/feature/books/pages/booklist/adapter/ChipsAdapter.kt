package com.example.testtask.feature.books.pages.booklist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testtask.R
import com.example.testtask.feature.books.pages.booklist.mvp.model.YearItem
import kotlinx.android.synthetic.main.item_chip.view.*

class ChipsAdapter(
    private val list: List<YearItem>,
    private val listener: (YearItem) -> Unit
) : RecyclerView.Adapter<ChipsAdapter.VH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_chip, parent, false)
        return VH(view, listener) { position ->
            notifyItemChanged(position)
        }
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        if (position in list.indices) {
            holder.bind(list[position], position)
        }
    }

    class VH(
        view: View,
        private val listener: (YearItem) -> Unit,
        private val notifier: (Int) -> Unit
    ) : RecyclerView.ViewHolder(view) {

        fun bind(item: YearItem, position: Int) = with(itemView) {
            cYearChip.text = item.year.toString()
            cYearChip.isChecked = item.isChecked
            cYearChip.setOnClickListener {
                item.isChecked = !item.isChecked
                notifier.invoke(position)
                listener.invoke(item)
            }
        }
    }
}