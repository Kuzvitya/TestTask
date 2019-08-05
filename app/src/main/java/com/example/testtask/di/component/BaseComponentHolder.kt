package com.example.testtask.di.component

import android.app.Application
import com.example.testtask.di.modules.AppModule
import com.example.testtask.di.modules.CiceroneModule
import com.example.testtask.di.modules.NetModule

object BaseComponentHolder {

    var baseComponent: BaseComponent? = null

    fun buildBaseComponent(application: Application) {
        baseComponent = DaggerBaseComponent.builder()
            .appModule(AppModule(application))
            .ciceroneModule(CiceroneModule())
            .netModule(NetModule())
            .build()
        baseComponent?.inject(this)
    }
}