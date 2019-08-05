package com.example.testtask.feature.books

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.testtask.feature.books.pages.bookdetails.BookDetailsFragment
import com.example.testtask.feature.books.pages.booklist.BooksListFragment

object BooksLauncher {

    const val BOOKS_LIST_PAGE = "booksListPage"
    const val BOOK_DETAILS_PAGE = "bookDetailPage"

    const val BOOK_ITEM_KEY = "bookItemKey"

    fun createIntent(context: Context, screenKey: String, data: Any?): Intent? {
        val intent: Intent? = when(screenKey) {
            else -> null
        }

        return intent?.apply {
            if (data != null && data is Bundle && !data.containsKey(Intent.EXTRA_TEXT)) {
                putExtras(data)
            }
        }
    }

    fun createFragment(screenKey: String, data: Any?): Fragment? {
        val fr: Fragment? = when (screenKey) {
            BOOKS_LIST_PAGE -> BooksListFragment()
            BOOK_DETAILS_PAGE -> BookDetailsFragment()
            else -> BooksListFragment()
        }

        return fr?.apply {
            arguments = (arguments ?: Bundle()).apply {
                (data as? Bundle)?.let { params ->
                    this.putAll(params)
                }
            }
        }
    }
}