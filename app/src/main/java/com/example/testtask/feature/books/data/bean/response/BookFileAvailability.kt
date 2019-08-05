package com.example.testtask.feature.books.data.bean.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class BookFileAvailability(

    @SerializedName("isAvailable")
    @Expose
    val isAvailable: Boolean?
)