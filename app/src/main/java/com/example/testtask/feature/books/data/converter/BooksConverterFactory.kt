package com.example.testtask.feature.books.data.converter

import com.example.testtask.base.network.converter.ConverterFactory
import com.example.testtask.base.network.converter.OneWayConverter
import com.example.testtask.feature.books.data.bean.response.BookDataModel

class BooksConverterFactory: ConverterFactory {

    @Suppress("UNCHECKED_CAST")
    override fun <T, S> getConverter(clazzFrom: Class<T>, clazzTo: Class<S>): OneWayConverter<T, S> {
        return when(clazzFrom) {
            BookDataModel::class.java -> BookDataModelConverter()
            else -> throw IllegalStateException(
                "Converter from ${clazzFrom.simpleName} to ${clazzTo.simpleName} not found"
            )
        } as OneWayConverter<T, S>
    }
}