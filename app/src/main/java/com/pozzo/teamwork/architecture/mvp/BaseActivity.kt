package com.pozzo.teamwork.architecture.mvp

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import com.pozzo.teamwork.R
import com.pozzo.teamwork.architecture.App
import com.pozzo.teamwork.architecture.injection.AppComponent

/**
 * Provides basic abstraction of an activity, should improve development speed by implementing
 *  generic functionalities and development tools.
 * Should also tend to help maintaining implementation similar through the application.
 *
 * @since 27/07/17.
 */
abstract class BaseActivity : Activity(), BaseView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val app = App[this]
        onCreateComponent(app.component())
    }

    protected abstract fun onCreateComponent(appComponent: AppComponent)

    override fun showLoading() {
        Toast.makeText(this, R.string.loading, Toast.LENGTH_SHORT).show()
    }

    override fun hideLoading() {
        Toast.makeText(this, R.string.loaded, Toast.LENGTH_SHORT).show()
    }

    override fun error(error: Throwable) {
        val message = getString(R.string.error) + " " + error.localizedMessage
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    fun addFragment(fragment: BaseFragment, id: Int) {
        fragmentManager.beginTransaction()
                .add(id, fragment)
                .commit()
    }

    fun replaceFragment(fragment: BaseFragment, id: Int) {
        fragmentManager.beginTransaction()
                .replace(id, fragment)
                .commit()
    }
}
