package com.example.testtask.feature.books.domain.interactor

import com.example.testtask.feature.books.domain.controllers.BookFilterComposer
import com.example.testtask.feature.books.domain.model.BookModel
import com.example.testtask.feature.books.domain.repo.BooksRepository
import io.reactivex.Single
import javax.inject.Inject

class BooksInteractor @Inject constructor(
    private val repo: BooksRepository
) {

    val books: MutableList<BookModel> = mutableListOf()

    fun getBooks(): Single<List<BookModel>> {
        return repo.getBooks()
            .map {
                books.clear()
                books.addAll(it)
                it
            }
    }

    fun searchBooks(query: String? = null, years: List<Int> = listOf()): Single<List<BookModel>> {
        return Single.just(books)
            .compose(BookFilterComposer(query, years))
    }

}