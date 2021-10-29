package com.kudashov.testdagger.di.components

import com.kudashov.testdagger.App
import com.kudashov.testdagger.MainActivity
import com.kudashov.testdagger.Presenter
import com.kudashov.testdagger.PresenterImpl
import dagger.Component
import dagger.Module
import dagger.Provides

@Component(dependencies = [AppComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {

    @Component.Builder
    interface Builder {

        fun appComponent(appComponent: AppComponent): Builder

        fun build(): ActivityComponent
    }
    fun inject(mainActivity: MainActivity)
}

@Module
class ActivityModule {

    @Provides
    fun providePresenter(app: App): Presenter {
        return PresenterImpl(app)
    }
}