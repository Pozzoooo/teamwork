package com.pozzo.teamwork.architecture

import android.app.Application
import android.content.Context

import com.pozzo.teamwork.architecture.injection.AppComponent
import com.pozzo.teamwork.architecture.injection.AppModule
import com.pozzo.teamwork.architecture.injection.DaggerAppComponent

/**
 * @since 27/07/17.
 */
class App : Application() {
    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        initComponent()
    }

    fun component(): AppComponent {
        return appComponent
    }

    protected val appModule: AppModule
        get() = AppModule(this)

    protected fun initComponent() {
        appComponent = DaggerAppComponent.builder()
                .appModule(appModule)
                .build()
    }

    companion object {

        operator fun get(context: Context): App {
            return context.applicationContext as App
        }
    }
}
