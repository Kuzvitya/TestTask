package com.example.testtask.base.framework

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.view.MenuItem
import android.view.View
import com.arellomobile.mvp.MvpAppCompatFragment
import com.example.testtask.R
import com.example.testtask.base.mvp.BaseView
import com.example.testtask.tools.extensions.visible

abstract class CoreFragment : MvpAppCompatFragment(), BaseView {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                activity?.onBackPressed()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun setTitle(title: String) {
        activity?.title = title
    }

    override fun setTitle(@StringRes titleRes: Int) {
        activity?.setTitle(titleRes)
    }

    override fun showLoader(show: Boolean) {
    }

    override fun showError(throwable: Throwable) {
    }

    protected fun initDefaultToolbar() {
        initToolbar(R.id.actionbarAccent)
    }



    private fun initToolbar(@IdRes containerId: Int) {
        val container = view?.findViewById<View>(containerId)
        val toolbar = container?.findViewById<Toolbar>(R.id.toolbar)
        toolbar?.let {
            (activity as? AppCompatActivity)?.setSupportActionBar(toolbar)
            (toolbar.parent as? View).visible()
            (activity as? AppCompatActivity)?.supportActionBar?.let {
                it.setDisplayHomeAsUpEnabled(true)
                it.setHomeButtonEnabled(true)
            }
        }
    }


}