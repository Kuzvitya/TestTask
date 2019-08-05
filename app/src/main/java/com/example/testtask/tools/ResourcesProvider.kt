package com.example.testtask.tools

import android.content.Context
import androidx.annotation.StringRes

class ResourcesProvider(
    private val context: Context
) {

    fun getString(@StringRes text: Int, context: Context = this.context): String =
            context.getString(text)

    fun getString(@StringRes text: Int, vararg formatArgs: Any, context: Context = this.context): String =
            context.getString(text, *formatArgs)
}