package com.pozzo.teamwork.architecture.mvp

/**
 * @since 27/07/17.
 */
interface BaseView {
    fun onBackPressed()
    fun finish()

    fun showLoading()
    fun hideLoading()

    fun error(error: Throwable)
}
