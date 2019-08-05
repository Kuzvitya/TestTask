package com.example.testtask.base.mvp

import androidx.annotation.StringRes
import com.arellomobile.mvp.MvpView

interface BaseView : MvpView {



    fun showLoader(show: Boolean)

    fun showError(throwable: Throwable)
    fun setTitle(title: String)
    fun setTitle(@StringRes titleRes: Int)
}