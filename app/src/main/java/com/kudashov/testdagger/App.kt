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

@Component(modules = [AppModule::class])
interface AppComponent{
    val viewModel: ViewModel
}

@Module
class AppModule{

    @Provides
    fun provideViewModel(): ViewModel{
        return ViewModel()
    }
}

class ViewModel()