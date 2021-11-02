package com.kudashov.testdagger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.kudashov.testdagger.di.components.ActivityComponent
import com.kudashov.testdagger.di.components.DaggerActivityComponent
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var presenter: Presenter

    private var activityComponent: ActivityComponent? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        activityComponent = DaggerActivityComponent.builder()
            .appComponent(appComponent)
            .build()

        activityComponent!!.inject(this)
        presenter.doSmth()
    }

    override fun onDestroy() {
        super.onDestroy()
        activityComponent = null
    }
}