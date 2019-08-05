package com.example.testtask.feature.books.data.bean.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class BookIndustryIdentifier(

    @SerializedName("type")
    @Expose
    val type: String?,

    @SerializedName("identifier")
    @Expose
    val identifier: String?

)