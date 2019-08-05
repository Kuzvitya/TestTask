package com.example.testtask.di.modules

import android.os.Bundle
import com.example.testtask.base.framework.CoreFragment
import dagger.Module
import dagger.Provides

@Module
class BaseFragmentModule(
    private var fragment: CoreFragment
) {

    @Provides
    fun provideFragment() = fragment

    @Provides
    fun provideParams(): Bundle = fragment.arguments ?: Bundle.EMPTY
}