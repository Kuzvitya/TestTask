package com.example.testtask.feature.books.domain.repo

import com.example.testtask.feature.books.domain.model.BookModel
import io.reactivex.Single

interface BooksRepository {

    fun getBooks(): Single<List<BookModel>>
}