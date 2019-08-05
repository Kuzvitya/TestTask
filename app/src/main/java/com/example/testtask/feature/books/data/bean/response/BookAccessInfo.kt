package com.example.testtask.feature.books.data.bean.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class BookAccessInfo(

    @SerializedName("country")
    @Expose
    val country: String?,

    @SerializedName("viewability")
    @Expose
    val viewability: String?,

    @SerializedName("embeddable")
    @Expose
    val embeddable: Boolean?,

    @SerializedName("publicDomain")
    @Expose
    val publicDomain: Boolean?,

    @SerializedName("textToSpeechPermission")
    @Expose
    val textToSpeechPermission: String?,

    @SerializedName("epub")
    @Expose
    val epub: BookFileAvailability?,

    @SerializedName("pdf")
    @Expose
    val pdf: BookFileAvailability?,

    @SerializedName("webReaderLink")
    @Expose
    val webReaderLink: String?,

    @SerializedName("accessViewStatus")
    @Expose
    val accessViewStatus: String?,

    @SerializedName("quoteSharingAllowed")
    @Expose
    val quoteSharingAllowed: Boolean?
)