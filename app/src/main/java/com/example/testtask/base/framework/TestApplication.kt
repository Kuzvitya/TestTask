package com.example.testtask.base.framework

import android.app.Application
import com.example.testtask.di.component.BaseComponentHolder

class TestApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        BaseComponentHolder.buildBaseComponent(this)
    }
}