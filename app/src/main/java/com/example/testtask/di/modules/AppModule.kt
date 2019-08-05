package com.example.testtask.di.modules

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.example.testtask.tools.PrefsManager
import com.example.testtask.tools.ResourcesProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(
    private val app: Application
) {


    @Singleton
    @Provides
    fun provideApplication(): Application = app

    @Singleton
    @Provides
    fun provideApplicationContext(): Context = app.applicationContext

    @Singleton
    @Provides
    fun providePrefsManager(): PrefsManager = PrefsManager()

    @Singleton
    @Provides
    fun provideSharedPreferences(context: Context, prefsManager: PrefsManager): SharedPreferences {
        return prefsManager.getDefaultSharedPreference(context)
    }

    @Singleton
    @Provides
    fun provideResourceProvider(context: Context) = ResourcesProvider(context)

}