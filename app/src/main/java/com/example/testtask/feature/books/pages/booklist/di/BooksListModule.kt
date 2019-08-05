package com.example.testtask.feature.books.pages.booklist.di

import com.example.testtask.di.scope.PerScreenScope
import com.example.testtask.feature.books.domain.model.BookModel
import com.example.testtask.feature.books.pages.booklist.mvp.model.YearItem
import com.example.testtask.tools.listbuilder.ListBuilderDirector
import dagger.Module
import dagger.Provides

@Module
class BooksListModule {

    @PerScreenScope
    @Provides
    fun provideDirector(): ListBuilderDirector<BookModel> = ListBuilderDirector()

    @PerScreenScope
    @Provides
    fun provideChipsDirector(): ListBuilderDirector<YearItem> = ListBuilderDirector()
}