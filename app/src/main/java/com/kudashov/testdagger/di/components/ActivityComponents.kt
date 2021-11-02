package com.kudashov.testdagger.di.components

import com.kudashov.testdagger.App
import com.kudashov.testdagger.MainActivity
import com.kudashov.testdagger.Presenter
import com.kudashov.testdagger.PresenterImpl
import com.kudashov.testdagger.di.scope.ActivityScope
import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Qualifier
import javax.inject.Scope

@ActivityScope
@Component(dependencies = [AppComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {

    fun appComponent(appComponent: AppComponent)

/*    @Component.Builder
    interface Builder {

        fun appComponent(appComponent: AppComponent): Builder

        fun build(): ActivityComponent
    }*/

    fun inject(mainActivity: MainActivity)
}

@Module
class ActivityModule {

    @ActivityScope
    @Provides
    fun providePresenter(app: App): Presenter {
        return PresenterImpl(app)
    }
}
