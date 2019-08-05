package com.example.testtask.tools

import android.content.Context
import android.content.SharedPreferences

class PrefsManager {

    fun getDefaultSharedPreference(context: Context): SharedPreferences {
        return context.getSharedPreferences(DEFAULT_SHARED_PREFERENCE, Context.MODE_PRIVATE)
    }

    companion object {
        const val DEFAULT_SHARED_PREFERENCE = "defaultSharedPreference"
    }
}