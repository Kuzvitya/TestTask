package com.example.testtask.di.composers

import com.example.testtask.base.mvp.BaseView
import io.reactivex.Single
import io.reactivex.SingleSource
import io.reactivex.SingleTransformer
import io.reactivex.android.schedulers.AndroidSchedulers

class ViewStateComposerSingle<T>(private val view: BaseView) : SingleTransformer<T, T> {

    override fun apply(upstream: Single<T>): SingleSource<T> {
        return upstream
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { view.showLoader(true) }
            .doFinally { view.showLoader(false) }
    }
}