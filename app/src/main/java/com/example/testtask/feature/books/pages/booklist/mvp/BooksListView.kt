package com.example.testtask.feature.books.pages.booklist.mvp

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.testtask.base.mvp.BaseView
import com.example.testtask.feature.books.domain.model.BookModel
import com.example.testtask.feature.books.pages.booklist.mvp.model.YearItem
import com.example.testtask.tools.listbuilder.AdapterList

interface BooksListView : BaseView {
    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showList(items: AdapterList<BookModel>)

    @StateStrategyType(SkipStrategy::class)
    fun showEmptyList()

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun invokeOkListState()

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showChipsList(items: AdapterList<YearItem>)
}