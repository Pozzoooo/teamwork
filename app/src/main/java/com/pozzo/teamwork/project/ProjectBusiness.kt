package com.pozzo.teamwork.project

import com.pozzo.teamwork.project.model.Project

/**
 * Business logic regarding Project.
 *
 * @see Project
 * @since 28/07/17.
 */
class ProjectBusiness(private val projectClient: ProjectClient) {
    /**
     * @return request all projects from logged in user.
     */
    fun getAllProjects(): List<Project> {
        return projectClient.downloadAllProjects()
    }
}