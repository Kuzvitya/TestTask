package com.example.testtask.di.modules

import com.example.testtask.base.network.host.BaseHostImpl
import com.example.testtask.base.network.host.Host
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class HostModule {

    @Singleton
    @Provides
    fun provideBaseHost(): Host {
        return BaseHostImpl()
    }
}