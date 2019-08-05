package com.example.testtask.feature.books

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.testtask.R
import com.example.testtask.base.framework.CoreActivity
import com.example.testtask.feature.books.di.BooksComponent
import com.example.testtask.feature.books.di.BooksComponentHolder

class BooksActivity : CoreActivity() {

    lateinit var booksComponent: BooksComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        booksComponent = BooksComponentHolder.getComponent()
        booksComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        savedInstanceState ?: loadPage()
    }

    override fun onDestroy() {
        super.onDestroy()
        BooksComponentHolder.releaseComponent()
    }

    override fun createFragmentForCiceroneNavigator(screenKey: String, data: Any?): Fragment? {
        return BooksLauncher.createFragment(screenKey, data)
    }

    override fun createIntentForCiceroneNavigator(context: Context, screenKey: String, data: Any?): Intent? {
        return BooksLauncher.createIntent(context, screenKey, data)
    }

    override fun setResultListeners() {

    }

    private fun loadPage() {
        router.replaceScreen(intent?.action, intent?.extras)
    }


}