package com.pozzo.teamwork.user

import dagger.Module
import dagger.Provides

/**
 * @since 27/07/17.
 */
@Module
class UserModule {

    @Provides
    fun provideLoggedInUser(): User {
        return User(username = "yat@triplespin.com", password = "yatyatyat27")
    }
}
