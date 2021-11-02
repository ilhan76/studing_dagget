package com.kudashov.testdagger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kudashov.testdagger.di.components.DaggerActivityComponent
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var presenter: Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val activityComponent = DaggerActivityComponent.builder()
            .appComponent(appComponent)
            .build()
        activityComponent.inject(this)
        presenter.doSmth()
    }
}