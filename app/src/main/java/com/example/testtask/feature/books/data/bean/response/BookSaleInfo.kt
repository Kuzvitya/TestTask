package com.example.testtask.feature.books.data.bean.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class BookSaleInfo(

    @SerializedName("country")
    @Expose
    val country: String?,

    @SerializedName("saleability")
    @Expose
    val saleability: String?,

    @SerializedName("isEbook")
    @Expose
    val isEbook: Boolean?,

    @SerializedName("listPrice")
    @Expose
    val listPrice: BookPrice?,

    @SerializedName("retailPrice")
    @Expose
    val retailPrice: BookPrice?,

    @SerializedName("offers")
    @Expose
    val offers: List<BookOffer> = listOf()
)