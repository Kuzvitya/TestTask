package com.example.testtask.feature.books.data.bean.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class BookReadingModes(

    @SerializedName("text")
    @Expose
    val text: Boolean?,

    @SerializedName("image")
    @Expose
    val image: Boolean?

)