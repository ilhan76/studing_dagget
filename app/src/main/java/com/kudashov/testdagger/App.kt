package com.kudashov.testdagger

import android.app.Application
import android.content.Context
import com.kudashov.testdagger.di.components.AppComponent
import com.kudashov.testdagger.di.components.DaggerAppComponent

class App : Application() {

    var appComponent: AppComponent = DaggerAppComponent.builder()
        .deps(this)
        .build()

}

val Context.appComponent: AppComponent
    get() = when (this) {
        is App -> appComponent
        else -> this.applicationContext.appComponent
    }