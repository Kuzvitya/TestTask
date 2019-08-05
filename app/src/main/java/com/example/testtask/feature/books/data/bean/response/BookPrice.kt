package com.example.testtask.feature.books.data.bean.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class BookPrice(

    @SerializedName("amount", alternate = ["amountInMicros"])
    @Expose
    val amount: Float?,

    @SerializedName("currencyCode")
    @Expose
    val currencyCode: String?
)