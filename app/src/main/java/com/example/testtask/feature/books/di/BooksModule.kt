package com.example.testtask.feature.books.di

import com.example.testtask.di.scope.PerFeatureScope
import com.example.testtask.feature.books.data.api.BooksApi
import com.example.testtask.feature.books.data.converter.BooksConverterFactory
import com.example.testtask.feature.books.data.repository.BooksRepositoryImpl
import com.example.testtask.feature.books.domain.repo.BooksRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class BooksModule {

    @PerFeatureScope
    @Provides
    fun bindRepository(retrofit: Retrofit): BooksRepository {
        return BooksRepositoryImpl(
            retrofit.create(BooksApi::class.java),
            BooksConverterFactory()
        )
    }

}