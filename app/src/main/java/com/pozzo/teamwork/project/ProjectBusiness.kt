package com.pozzo.teamwork.project

import com.pozzo.teamwork.project.model.Project

/**
 * @since 28/07/17.
 */
class ProjectBusiness {
    private var projectClient: ProjectClient

    constructor(projectClient: ProjectClient) {
        this.projectClient = projectClient
    }

    /**
     * @return request all projects from logged in user.
     */
    fun getAllProjects(): List<Project> {
        return projectClient.downloadAllProjects()
    }
}