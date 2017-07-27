package com.pozzo.teamwork.architecture.mvp

import android.app.Activity
import android.os.Bundle

import com.pozzo.teamwork.architecture.App
import com.pozzo.teamwork.architecture.injection.AppComponent

/**
 * @since 27/07/17.
 */
abstract class BaseActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val app = App.get(this)
        onCreateComponent(app.component())
    }

    protected abstract fun onCreateComponent(appComponent: AppComponent)
}
