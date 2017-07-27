package com.pozzo.teamwork.user

/**
 * @since 27/07/17.
 */
data class User(val username: String, val password: String) {
    fun credentials(): String {
        return "$username:$password"
    }
}
