package com.example.testtask.feature.books.pages.bookdetails.mvp

import com.arellomobile.mvp.InjectViewState
import com.example.testtask.base.mvp.BasePresenter
import com.example.testtask.feature.books.BooksLauncher
import com.example.testtask.feature.books.domain.model.BookModel
import org.threeten.bp.format.DateTimeFormatter
import javax.inject.Inject
import javax.inject.Named

@InjectViewState
class BookDetailsPresenter @Inject constructor(
    @Named(BooksLauncher.BOOK_ITEM_KEY)
    private val book: BookModel?
) : BasePresenter<BookDetailsView>() {

    private val dateFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        book?.let {
            viewState.showData(
                it.title,
                it.description,
                dateFormatter.format(it.publishedDate),
                it.coverImageLarge
            )
        }
    }

}