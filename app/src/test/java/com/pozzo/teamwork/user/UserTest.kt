package com.pozzo.teamwork.user

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * @author root
 * *
 * @since 30/07/17.
 */
class UserTest {
    @Test
    fun shouldReturnCredentialsBasedOnUsernameAndPassword() {
        val user = User("username", "password")
        assertEquals("username:password", user.credentials())
    }
}
