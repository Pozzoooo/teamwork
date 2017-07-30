package com.pozzo.teamwork.architecture.mvp

/**
 * Generic interface that the view layer should implement to make use of shared tools.
 *
 * @since 27/07/17.
 */
interface BaseView {
    fun onBackPressed()
    fun finish()

    fun showLoading()
    fun hideLoading()

    fun error(error: Throwable)
}
