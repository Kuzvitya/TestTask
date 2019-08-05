package com.example.testtask.base.mvp

import com.arellomobile.mvp.MvpPresenter
import io.reactivex.disposables.CompositeDisposable

open class BasePresenter<V : BaseView> : MvpPresenter<V>() {

    var disposable: CompositeDisposable? = null

    override fun attachView(view: V) {
        disposable = CompositeDisposable()
        super.attachView(view)
    }

    override fun detachView(view: V) {
        super.detachView(view)
        disposable?.dispose()
        disposable = null
    }
}