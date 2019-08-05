package com.example.testtask.tools.extensions

import android.view.View

fun View?.visible(show: Boolean = true) {
    if (show) {
        this?.visibility = View.VISIBLE
    } else {
        this?.visibility = View.GONE
    }
}