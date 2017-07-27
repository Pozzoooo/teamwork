package com.pozzo.teamwork.architecture.injection

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

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
