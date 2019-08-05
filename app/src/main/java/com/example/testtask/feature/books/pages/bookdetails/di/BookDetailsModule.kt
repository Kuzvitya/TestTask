package com.example.testtask.feature.books.pages.bookdetails.di

import android.os.Bundle
import com.example.testtask.di.scope.PerScreenScope
import com.example.testtask.feature.books.BooksLauncher
import com.example.testtask.feature.books.domain.model.BookModel
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class BookDetailsModule {

    @PerScreenScope
    @Provides
    @Named(BooksLauncher.BOOK_ITEM_KEY)
    fun provideBookModel(params: Bundle): BookModel? =
            params.getParcelable(BooksLauncher.BOOK_ITEM_KEY)
}