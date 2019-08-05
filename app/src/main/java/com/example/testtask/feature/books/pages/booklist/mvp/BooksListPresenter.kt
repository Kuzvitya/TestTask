package com.example.testtask.feature.books.pages.booklist.mvp

import android.os.Bundle
import com.arellomobile.mvp.InjectViewState
import com.example.testtask.base.mvp.BasePresenter
import com.example.testtask.di.composers.ViewStateComposerSingle
import com.example.testtask.feature.books.BooksLauncher
import com.example.testtask.feature.books.domain.interactor.BooksInteractor
import com.example.testtask.feature.books.domain.model.BookModel
import com.example.testtask.feature.books.pages.booklist.mvp.model.YearItem
import com.example.testtask.tools.listbuilder.AdapterList
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class BooksListPresenter @Inject constructor(
    private val interactor: BooksInteractor,
    private val router: Router
) : BasePresenter<BooksListView>() {

    private val items: AdapterList<BookModel> = AdapterList()
    private val yearItems: AdapterList<YearItem> = AdapterList()

    private val selectedYears: MutableList<Int> = mutableListOf()
    private var query: String? = null

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        getBooks()
    }

    fun onItemClick(item: BookModel) {
        router.navigateTo(BooksLauncher.BOOK_DETAILS_PAGE, Bundle().apply {
            putParcelable(BooksLauncher.BOOK_ITEM_KEY, item)
        })
    }

    fun onSearchQueryChanged(query: String) {
        this.query = query
        filterBooks()
    }

    fun onChipPressed(item: YearItem) {
        if (item.isChecked) {
            selectedYears.add(item.year)
        } else {
            selectedYears.remove(item.year)
        }
        filterBooks()
    }

    private fun getBooks() {
        disposable?.add(
            interactor.getBooks()
                .compose(ViewStateComposerSingle(viewState))
                .subscribe({ list ->
                    processYears(list)
                    processResponse(list)
                },
                    viewState::showError
                ))
    }

    private fun filterBooks() {
        disposable?.add(
            interactor.searchBooks(query, selectedYears)
                .subscribe(
                    this::processResponse,
                    viewState::showError
                ))
    }

    private fun processYears(list: List<BookModel>) {
        val years = list
            .map { item ->
                item.publishedDate.year
            }
            .distinct()
            .sorted()
            .map { item ->
                YearItem(item)
            }
        yearItems.adapter ?: viewState.showChipsList(yearItems)
        yearItems.addList(years)
    }

    private fun processResponse(list: List<BookModel>) {
        items.adapter ?: viewState.showList(items)
        items.addList(list)
        if (list.isEmpty()) {
            viewState.showEmptyList()
        } else {
            viewState.invokeOkListState()
        }
    }
}