package com.example.testtask.feature.books.di

import com.example.testtask.feature.books.domain.repo.BooksRepository

interface BooksComponentDependencies {

    fun provideRepository(): BooksRepository
}