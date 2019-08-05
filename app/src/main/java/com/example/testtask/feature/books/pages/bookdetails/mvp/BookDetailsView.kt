package com.example.testtask.feature.books.pages.bookdetails.mvp

import com.example.testtask.base.mvp.BaseView

interface BookDetailsView : BaseView {

    fun showData(title: String, description: String, dateString: String, imageLink: String)
}