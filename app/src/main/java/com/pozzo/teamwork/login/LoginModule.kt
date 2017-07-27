package com.pozzo.teamwork.login

import com.pozzo.teamwork.user.User
import com.pozzo.teamwork.user.UserModule
import dagger.Module
import dagger.Provides

/**
 * @since 27/07/17.
 */
@Module(includes = arrayOf(UserModule::class))
class LoginModule {

    @Provides
    fun provideBasicAuthorizationInterceptor(loggedInUser: User): BasicAuthorizationInterceptor {
        return BasicAuthorizationInterceptor(loggedInUser)
    }
}
