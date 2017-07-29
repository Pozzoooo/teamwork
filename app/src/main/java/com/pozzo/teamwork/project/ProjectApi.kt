package com.pozzo.teamwork.project

import com.pozzo.teamwork.project.model.Projects
import retrofit2.Call
import retrofit2.http.GET

/**
 * @since 27/07/17.
 */
interface ProjectApi {

    @GET("projects.json")
    fun projects(): Call<Projects>
}
