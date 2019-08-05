package com.example.testtask.feature.books.data.bean.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class BookSearchInfo(

    @SerializedName("textSnippet")
    @Expose
    val textSnippet: String?

)