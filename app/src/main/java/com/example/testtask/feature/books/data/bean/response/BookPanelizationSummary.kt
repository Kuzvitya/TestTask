package com.example.testtask.feature.books.data.bean.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class BookPanelizationSummary(

    @SerializedName("containsEpubBubbles")
    @Expose
    val containsEpubBubbles: Boolean?,

    @SerializedName("containsImageBubbles")
    @Expose
    val containsImageBubbles: Boolean?

)