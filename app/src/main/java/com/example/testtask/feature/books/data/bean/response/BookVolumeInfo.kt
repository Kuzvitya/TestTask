package com.example.testtask.feature.books.data.bean.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import org.threeten.bp.LocalDate

data class BookVolumeInfo(

    @SerializedName("title")
    @Expose
    val title: String?,

    @SerializedName("subtitle")
    @Expose
    val subtitle: String?,

    @SerializedName("authors")
    @Expose
    val authors: List<String> = listOf(),

    @SerializedName("publisher")
    @Expose
    val publisher: String?,

    @SerializedName("publishedDate")
    @Expose
    val publishedDate: LocalDate?,

    @SerializedName("description")
    @Expose
    val description: String?,

    @SerializedName("industryIdentifiers")
    @Expose
    val industryIdentifiers: List<BookIndustryIdentifier> = listOf(),

    @SerializedName("readingModes")
    @Expose
    val readingModes: BookReadingModes?,

    @SerializedName("pageCount")
    @Expose
    val pageCount: Int?,

    @SerializedName("printType")
    @Expose
    val printType: String?,

    @SerializedName("categories")
    @Expose
    val categories: List<String> = listOf(),

    @SerializedName("maturityRating")
    @Expose
    val maturityRating: String?,

    @SerializedName("allowAnonLogging")
    @Expose
    val allowAnonLogging: Boolean?,

    @SerializedName("contentVersion")
    @Expose
    val contentVersion: String?,

    @SerializedName("panelizationSummary")
    @Expose
    val panelizationSummary: BookPanelizationSummary?,

    @SerializedName("imageLinks")
    @Expose
    val imageLinks: BookImageLinks?,

    @SerializedName("language")
    @Expose
    val language: String?,

    @SerializedName("previewLink")
    @Expose
    val previewLink: String?,

    @SerializedName("infoLink")
    @Expose
    val infoLink: String?,

    @SerializedName("canonicalVolumeLink")
    @Expose
    val canonicalVolumeLink: String?

)