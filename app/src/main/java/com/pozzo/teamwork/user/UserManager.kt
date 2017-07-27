package com.pozzo.teamwork.user

import dagger.Module
import dagger.Provides

/**
 * @since 27/07/17.
 */
@Module
class UserManager {

    @Provides
    fun provideLoggedInUser(): User {
        return User("yat@triplespin.com", "yatyatyat27")
    }
}
