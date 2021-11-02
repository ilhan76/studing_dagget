package com.kudashov.testdagger.di.components

import ActivityScope
import com.kudashov.testdagger.App
import com.kudashov.testdagger.MainActivity
import com.kudashov.testdagger.Presenter
import com.kudashov.testdagger.PresenterImpl
import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Qualifier

@Component(dependencies = [AppComponent::class], modules = [ActivityModule::class])
@ActivityScope
interface ActivityComponent {

    @Component.Builder
    interface Builder {

        fun appComponent(appComponent: AppComponent): Builder

        fun build(): ActivityComponent
    }

    fun inject(mainActivity: MainActivity)
}

@Module(includes = [ActivityBindModule::class])
class ActivityModule {

    @Provides
    @ActivityScope
    fun providePresenter(app: App): Presenter {
        return PresenterImpl(app)
    }
}

@Module
interface ActivityBindModule{
    @Binds
    fun bindPresenter(presenterImpl: PresenterImpl): Presenter
}

