package com.pozzo.teamwork.project

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

/**
 * @since 27/07/17.
 */
interface ProjectApi {

    @GET("projects.json")
    fun projects(): Call<Projects>
}
