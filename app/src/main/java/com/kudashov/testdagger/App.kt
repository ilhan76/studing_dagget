package com.kudashov.testdagger

import android.app.Application
import android.content.Context
import com.kudashov.testdagger.di.components.AppComponent
import com.kudashov.testdagger.di.components.DaggerAppComponent
import javax.inject.Inject

class App : Application() {

    var appComponent: AppComponent = DaggerAppComponent.builder()
        .app(this)
        .build()

}

val Context.appComponent: AppComponent
    get() = when (this) {
        is App -> appComponent
        else -> this.applicationContext.appComponent
    }