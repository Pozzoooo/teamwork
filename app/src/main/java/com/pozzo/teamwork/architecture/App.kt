package com.pozzo.teamwork.architecture

import android.app.Application
import android.content.Context

import com.pozzo.teamwork.architecture.injection.AppComponent
import com.pozzo.teamwork.architecture.injection.AppModule
import com.pozzo.teamwork.architecture.injection.DaggerAppComponent

/**
 * App initialization.
 *
 * @since 27/07/17.
 */
class App : Application() {
    companion object {
        operator fun get(context: Context): App {
            return context.applicationContext as App
        }
    }

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        initComponent()
    }

    fun component(): AppComponent {
        return appComponent
    }

    private val appModule: AppModule
        get() = AppModule(this)

    private fun initComponent() {
        appComponent = DaggerAppComponent.builder()
                .appModule(appModule)
                .build()
    }
}
