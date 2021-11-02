package com.kudashov.testdagger.di.components

import com.kudashov.testdagger.App
import dagger.*

@Component
interface AppComponent {

    fun application(): App

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun deps(app: App): Builder

        fun build(): AppComponent
    }
}