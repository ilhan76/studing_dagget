package com.kudashov.testdagger

import android.app.Application
import android.content.Context
import com.kudashov.testdagger.di.components.AppComponent
import com.kudashov.testdagger.di.components.DaggerAppComponent
import com.kudashov.testdagger.di.interfases.AppDeps

class App: Application(), AppDeps {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .deps(this)
            .build()
    }

    override val application: App = this
}

val Context.appComponent: AppComponent
    get() = when (this) {
        is App -> appComponent
        else -> this.applicationContext.appComponent
    }