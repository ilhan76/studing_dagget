package com.kudashov.testdagger

import android.util.Log
import android.widget.Toast
import javax.inject.Inject

interface Presenter {
    fun doSmth()
}

class PresenterImpl @Inject constructor(val application: App) : Presenter {
    override fun doSmth() {
        Log.i("TAG", "doSmth: Presenter are doing something")
        Toast.makeText(application.applicationContext, "Presenter are doing something", Toast.LENGTH_SHORT).show()
    }
}