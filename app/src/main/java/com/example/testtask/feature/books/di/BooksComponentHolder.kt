package com.example.testtask.feature.books.di

import com.example.testtask.di.component.BaseComponentHolder

object BooksComponentHolder {

    private var component: BooksComponent? = null

    fun getComponent(): BooksComponent {
        return component ?: createComponent()
    }

    fun releaseComponent() {
        component = null
    }

    private fun createComponent(): BooksComponent {
        val component = DaggerBooksComponent.builder()
            .dependencies(BaseComponentHolder.baseComponent)
            .build()
        this.component = component
        return component
    }
}