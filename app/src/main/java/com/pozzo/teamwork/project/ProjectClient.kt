package com.pozzo.teamwork.project

import com.pozzo.teamwork.project.model.Project

/**
 * Network client to request Project web services.
 *
 * @since 28/07/17.
 */
class ProjectClient(private val projectApi: ProjectApi) {
    /**
     * @return request all projects from logged in user.
     */
    fun downloadAllProjects(): List<Project> {
        val call = projectApi.projects()
        val response = call.execute()
        return response.body()?.projects ?: ArrayList()
    }
}
