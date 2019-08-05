package com.example.testtask.feature.books.data.bean.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class BookDataModel(

    @SerializedName("kind")
    @Expose
    val kind: String?,

    @SerializedName("id")
    @Expose
    val id: String?,

    @SerializedName("etag")
    @Expose
    val etag: String?,

    @SerializedName("selfLink")
    @Expose
    val selfList: String,

    @SerializedName("volumeInfo")
    @Expose
    val volumeInfo: BookVolumeInfo?,

    @SerializedName("saleInfo")
    @Expose
    val saleInfo: BookSaleInfo?,

    @SerializedName("accessInfo")
    @Expose
    val accessInfo: BookAccessInfo?,

    @SerializedName("searchInfo")
    @Expose
    val searchInfo: BookSearchInfo?
)