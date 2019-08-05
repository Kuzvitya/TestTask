package com.example.testtask.feature.books.data.converter

import com.example.testtask.base.network.converter.OneWayConverter
import com.example.testtask.feature.books.data.bean.response.BookDataModel
import com.example.testtask.feature.books.domain.model.BookModel
import com.example.testtask.tools.extensions.safeLet

class BookDataModelConverter: OneWayConverter<BookDataModel, BookModel>() {

    override fun convert(source: BookDataModel?): BookModel? {
        return source?.volumeInfo?.title?.safeLet(
            source.volumeInfo.description,
            source.volumeInfo.publishedDate,
            source.volumeInfo.imageLinks?.smallThumbnail,
            source.volumeInfo.imageLinks?.thumbnail
        ) { title, desc, date, imageSmall, imageBig ->
            BookModel(title, desc, date, imageSmall, imageBig)
        }
    }
}