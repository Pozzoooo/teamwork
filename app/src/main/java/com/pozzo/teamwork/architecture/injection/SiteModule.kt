package com.pozzo.teamwork.architecture.injection

import com.pozzo.teamwork.architecture.model.Site
import dagger.Module
import dagger.Provides

/**
 * @since 28/07/17.
 */
@Module
class SiteModule {

    @Provides
    fun provideSite(): Site {
        //todo should be setup after login
        val site = Site(baseUrl = "https://yat.teamwork.com/")
        return site
    }
}