package com.example.testtask.feature.books.pages.bookdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.bumptech.glide.Glide
import com.example.testtask.R
import com.example.testtask.base.framework.CoreFragment
import com.example.testtask.di.modules.BaseFragmentModule
import com.example.testtask.feature.books.BooksActivity
import com.example.testtask.feature.books.pages.bookdetails.mvp.BookDetailsPresenter
import com.example.testtask.feature.books.pages.bookdetails.mvp.BookDetailsView
import kotlinx.android.synthetic.main.layout_details_fragment.*
import javax.inject.Inject

class BookDetailsFragment : CoreFragment(), BookDetailsView {

    @Inject
    @InjectPresenter
    lateinit var presenter: BookDetailsPresenter

    @ProvidePresenter
    fun providePresenter() = presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        (activity as BooksActivity).booksComponent
            .bookDetailsComponent(BaseFragmentModule(this)).inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        inflater.inflate(R.layout.layout_details_fragment, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initDefaultToolbar()
        setTitle(R.string.book_details_title)
    }

    override fun showData(
        title: String,
        description: String,
        dateString: String,
        imageLink: String
    ) {
        tvName.text = title
        tvDescription.text = description
        tvDate.text = dateString

        context?.let {
            Glide.with(it)
                .load(imageLink)
                .into(ivCover)
        }


    }
}