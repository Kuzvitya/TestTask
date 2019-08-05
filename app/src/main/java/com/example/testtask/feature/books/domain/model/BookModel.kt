package com.example.testtask.feature.books.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import org.threeten.bp.LocalDate

@Parcelize
data class BookModel(
    val title: String,
    val description: String,
    val publishedDate: LocalDate,
    val coverImageSmall: String,
    val coverImageLarge: String
) : Parcelable