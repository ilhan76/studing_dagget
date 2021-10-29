package com.kudashov.testdagger.di.components

import com.kudashov.testdagger.App
import com.kudashov.testdagger.di.interfases.ActivityDeps
import com.kudashov.testdagger.di.interfases.AppDeps
import dagger.*


@Component(dependencies = [AppDeps::class])
interface AppComponent : ActivityDeps {

    override fun application(): App

    @Component.Builder
    interface Builder {

        fun deps(appDeps: AppDeps): Builder

        fun build(): AppComponent
    }
}