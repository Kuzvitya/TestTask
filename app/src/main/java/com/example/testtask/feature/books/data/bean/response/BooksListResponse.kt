package com.example.testtask.feature.books.data.bean.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class BooksListResponse(

    @SerializedName("kind")
    @Expose
    val kind: String?,

    @SerializedName("totalItems")
    @Expose
    val totalItems: Int?,

    @SerializedName("items")
    @Expose
    val items: List<BookDataModel> = listOf()
)