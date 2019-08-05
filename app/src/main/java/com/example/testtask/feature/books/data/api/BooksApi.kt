package com.example.testtask.feature.books.data.api

import com.example.testtask.feature.books.data.bean.response.BooksListResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface BooksApi {

    @GET("${BOOKS_API_GROUP}volumes")
    fun getBooks(
        @Query(GET_BOOKS_Q_PARAM_KEY) q: String,
        @Query(GET_BOOKS_MAX_RESULTS_PARAM_KEY) maxResults: Int)
            : Single<BooksListResponse>

    companion object {
        const val BOOKS_API_GROUP = "books/v1/"
        const val GET_BOOKS_Q_PARAM_KEY = "q"
        const val GET_BOOKS_MAX_RESULTS_PARAM_KEY = "maxResults"
    }
}