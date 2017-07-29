package com.pozzo.teamwork.architecture.mvp

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import com.pozzo.teamwork.architecture.App
import com.pozzo.teamwork.architecture.injection.AppComponent

/**
 * @since 27/07/17.
 */
abstract class BaseActivity : Activity(), BaseView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val app = App.get(this)
        onCreateComponent(app.component())
    }

    protected abstract fun onCreateComponent(appComponent: AppComponent)

    override fun showLoading() {
        Toast.makeText(this, "Loading", Toast.LENGTH_SHORT).show()
        //todo showLoading
    }

    override fun hideLoading() {
        Toast.makeText(this, "Loaded", Toast.LENGTH_SHORT).show()
        //todo hideLoading
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
