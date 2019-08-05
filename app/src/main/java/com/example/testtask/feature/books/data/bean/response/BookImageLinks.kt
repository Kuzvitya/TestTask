package com.example.testtask.feature.books.data.bean.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class BookImageLinks(

    @SerializedName("smallThumbnail")
    @Expose
    val smallThumbnail: String?,

    @SerializedName("thumbnail")
    @Expose
    val thumbnail: String?
)