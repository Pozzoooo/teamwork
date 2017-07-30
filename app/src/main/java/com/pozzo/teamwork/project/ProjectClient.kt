package com.pozzo.teamwork.project

import com.pozzo.teamwork.project.model.Project

/**
 * Network client to request Project web sevices.
 *
 * @since 28/07/17.
 */
class ProjectClient {
    private var projectApi: ProjectApi

    constructor(projectApi: ProjectApi) {
        this.projectApi = projectApi
    }

    /**
     * @return request all projects from logged in user.
     */
    fun downloadAllProjects(): List<Project> {
        val call = projectApi.projects()
        val response = call.execute()
        return response.body()?.projects ?: ArrayList()
    }
}
