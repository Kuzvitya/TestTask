package com.example.testtask.feature.books.pages.bookdetails.di

import com.example.testtask.di.modules.BaseFragmentModule
import com.example.testtask.di.scope.PerScreenScope
import com.example.testtask.feature.books.pages.bookdetails.BookDetailsFragment
import dagger.Subcomponent

@PerScreenScope
@Subcomponent(modules = [BookDetailsModule::class, BaseFragmentModule::class])
interface BookDetailsComponent {
    fun inject(fragment: BookDetailsFragment)
}