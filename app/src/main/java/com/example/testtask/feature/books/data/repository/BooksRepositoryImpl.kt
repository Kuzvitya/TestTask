package com.example.testtask.feature.books.data.repository

import com.example.testtask.base.network.converter.ConverterFactory
import com.example.testtask.feature.books.data.api.BooksApi
import com.example.testtask.feature.books.data.bean.response.BookDataModel
import com.example.testtask.feature.books.data.bean.response.BooksListResponse
import com.example.testtask.feature.books.domain.model.BookModel
import com.example.testtask.feature.books.domain.repo.BooksRepository
import io.reactivex.Single

class BooksRepositoryImpl(
    private val api: BooksApi,
    private val converterFactory: ConverterFactory
): BooksRepository {

    override fun getBooks(): Single<List<BookModel>> {
        val converter = converterFactory.getConverter(
            BookDataModel::class.java,
            BookModel::class.java
        )
        return api.getBooks(GET_BOOKS_Q_PARAM_VALUE, GET_BOOKS_MAX_RESULTS_PARAM_VALUE)
            .map(BooksListResponse::items)
            .map(converter::convert)
    }

    companion object {
        const val GET_BOOKS_Q_PARAM_VALUE = "kotlin"
        const val GET_BOOKS_MAX_RESULTS_PARAM_VALUE = 40
    }
}