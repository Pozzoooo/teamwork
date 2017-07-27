package com.pozzo.teamwork.injection

import android.app.Application

import javax.inject.Singleton

import dagger.Module
import dagger.Provides

/**
 * @since 27/07/17.
 */
@Module
class AppModule(private val mApplication: Application) {

    @Provides
    @Singleton
    internal fun providesApplication(): Application {
        return mApplication
    }
}
