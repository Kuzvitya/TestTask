package com.example.testtask.feature.books.data.bean.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class BookOffer(

    @SerializedName("finskyOfferType")
    @Expose
    val finskyOfferType: Int?,

    @SerializedName("listPrice")
    @Expose
    val listPrice: BookPrice?,

    @SerializedName("retailPrice")
    @Expose
    val retailPrice: BookPrice?
)