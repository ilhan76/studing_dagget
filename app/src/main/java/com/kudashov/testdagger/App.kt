package com.kudashov.testdagger

import android.app.Application
import dagger.Component
import dagger.Module
import dagger.Provides

class App : Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
    }
}

@Component()
interface AppComponent{
}