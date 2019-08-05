package com.example.testtask.feature.books.domain.controllers

import com.example.testtask.feature.books.domain.model.BookModel
import io.reactivex.Single
import io.reactivex.SingleSource
import io.reactivex.SingleTransformer

class BookFilterComposer(
    private val nameQuery: String?,
    private val years: List<Int>
) : SingleTransformer<List<BookModel>, List<BookModel>> {

    override fun apply(upstream: Single<List<BookModel>>): SingleSource<List<BookModel>> {
        return upstream
            .map { list ->
                if (nameQuery.isNullOrBlank()) {
                    return@map list
                }
                list.filter { item ->
                    item.title.contains(nameQuery, true)
                }
            }
            .map { list ->
                if (years.isEmpty()) {
                    return@map list
                }
                list.filter { item ->
                    years.contains(item.publishedDate.year)
                }
            }
    }
}