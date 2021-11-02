package com.kudashov.testdagger.di.components

import com.kudashov.testdagger.App
import com.kudashov.testdagger.di.interfases.ActivityDeps
import com.kudashov.testdagger.di.interfases.AppDeps
import com.kudashov.testdagger.di.scope.AppScope
import dagger.*
import javax.inject.Singleton

@Component(dependencies = [AppDeps::class])
@AppScope
interface AppComponent : ActivityDeps {

    override fun application(): App

    @Component.Builder
    interface Builder {

        fun deps(appDeps: AppDeps): Builder

        fun build(): AppComponent
    }
}