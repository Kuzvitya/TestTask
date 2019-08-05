package com.example.testtask.di.component

import com.example.testtask.di.modules.AppModule
import com.example.testtask.di.modules.CiceroneModule
import com.example.testtask.di.modules.HostModule
import com.example.testtask.di.modules.NetModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    CiceroneModule::class,
    NetModule::class,
    HostModule::class
])
interface BaseComponent : Dependencies {

    fun inject(holder: BaseComponentHolder)
}