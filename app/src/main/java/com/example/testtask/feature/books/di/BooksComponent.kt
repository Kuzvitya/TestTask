package com.example.testtask.feature.books.di

import com.example.testtask.di.component.Dependencies
import com.example.testtask.di.modules.BaseFragmentModule
import com.example.testtask.di.scope.PerFeatureScope
import com.example.testtask.feature.books.BooksActivity
import com.example.testtask.feature.books.pages.bookdetails.di.BookDetailsComponent
import com.example.testtask.feature.books.pages.booklist.di.BooksListComponent
import dagger.Component

@PerFeatureScope
@Component(
    modules = [BooksModule::class],
    dependencies = [Dependencies::class]
)
interface BooksComponent : BooksFeatureApi, BooksComponentDependencies {

    fun booksListComponent(module: BaseFragmentModule): BooksListComponent

    fun bookDetailsComponent(module: BaseFragmentModule): BookDetailsComponent

    fun inject(activity: BooksActivity)
}