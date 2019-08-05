package com.example.testtask.di.component

import com.example.testtask.tools.ResourcesProvider
import retrofit2.Retrofit
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router

interface Dependencies {

    fun getRetrofit(): Retrofit

    fun resourcesProvider(): ResourcesProvider

    fun router(): Router

    fun navigationHolder(): NavigatorHolder

}