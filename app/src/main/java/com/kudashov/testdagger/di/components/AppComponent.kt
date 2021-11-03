package com.kudashov.testdagger.di.components

import com.kudashov.testdagger.App
import dagger.*

@Component(dependencies = [App::class])
interface AppComponent {

    fun application(): App
}
