package com.example.testtask.feature.books.pages.booklist.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.testtask.R
import com.example.testtask.feature.books.domain.model.BookModel
import com.example.testtask.tools.ResourcesProvider
import kotlinx.android.synthetic.main.item_book.view.*
import org.threeten.bp.format.DateTimeFormatter

class BooksListAdapter(
    private val list: List<BookModel>,
    private val resourcesProvider: ResourcesProvider,
    private val listener: (BookModel) -> Unit
): RecyclerView.Adapter<BooksListAdapter.VH>() {

    private val dateFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_book, parent, false)
        return VH(view, resourcesProvider, dateFormatter, listener)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(viewHolder: VH, position: Int) {
        if (position in list.indices) {
            viewHolder.bind(list[position])
        }
    }

    class VH(
        view: View,
        private val resourcesProvider: ResourcesProvider,
        private val dateFormatter: DateTimeFormatter,
        private val listener: (BookModel) -> Unit
    ) : RecyclerView.ViewHolder(view) {

        fun bind(item: BookModel) = with(itemView) {
            tvName.text = item.title
            val formattedDate = item.publishedDate.format(dateFormatter)
            tvDate.text = resourcesProvider.getString(R.string.books_list_date_wildcard, formattedDate, context)
            Glide.with(context)
                .load(item.coverImageSmall)
                .into(ivIcon)

            setOnClickListener {
                listener.invoke(item)
            }
        }
    }
}