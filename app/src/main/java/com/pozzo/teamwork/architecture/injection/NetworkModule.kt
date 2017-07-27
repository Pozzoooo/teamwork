package com.pozzo.teamwork.architecture.injection

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.pozzo.teamwork.login.BasicAuthorizationInterceptor
import com.pozzo.teamwork.login.LoginModule
import com.pozzo.teamwork.user.UserModule
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * @since 27/07/17.
 */
@Module(includes = arrayOf(LoginModule::class))
class NetworkModule {

    @Provides
    @Singleton
    fun provideGson(): Gson {
        val gsonBuilder = GsonBuilder()
        return gsonBuilder.create()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(authorization: BasicAuthorizationInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
                .addInterceptor(authorization)
                .build()
    }

    @Provides
    @Singleton
    fun provideRetrofitBuilder(gson: Gson, okHttpClient: OkHttpClient): Retrofit.Builder {
        return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
    }
}
