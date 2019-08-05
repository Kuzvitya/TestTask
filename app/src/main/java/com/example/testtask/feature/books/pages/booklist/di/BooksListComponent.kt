package com.example.testtask.feature.books.pages.booklist.di

import com.example.testtask.di.modules.BaseFragmentModule
import com.example.testtask.di.scope.PerScreenScope
import com.example.testtask.feature.books.di.BooksModule
import com.example.testtask.feature.books.pages.booklist.BooksListFragment
import dagger.Subcomponent

@PerScreenScope
@Subcomponent(modules = [BooksListModule::class, BaseFragmentModule::class])
interface BooksListComponent {
    fun inject(fragment: BooksListFragment)
}