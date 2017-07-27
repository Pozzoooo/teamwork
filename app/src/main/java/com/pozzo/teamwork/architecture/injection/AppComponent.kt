package com.pozzo.teamwork.architecture.injection

import android.app.Application

import com.google.gson.Gson
import com.pozzo.teamwork.user.User
import com.pozzo.teamwork.user.UserModule

import javax.inject.Singleton

import dagger.Component
import okhttp3.OkHttpClient
import retrofit2.Retrofit

/**
 * @since 27/07/17.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class, NetworkModule::class, UserModule::class))
interface AppComponent {
    //App
    fun app(): Application

    //Network
    fun gson(): Gson
    fun okHttpClient(): OkHttpClient
    fun retrofitBuilder(): Retrofit.Builder

    //Session
    fun loggedInUser(): User
}
