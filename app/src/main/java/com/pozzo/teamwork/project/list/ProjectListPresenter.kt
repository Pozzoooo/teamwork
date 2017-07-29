package com.pozzo.teamwork.project.list

import com.pozzo.teamwork.architecture.mvp.BasePresenter
import com.pozzo.teamwork.project.ProjectBusiness
import com.pozzo.teamwork.project.model.Project
import javax.inject.Inject

/**
 * @since 27/07/17.
 */
class ProjectListPresenter: BasePresenter<ProjectListView> {
    private var projectBusiness: ProjectBusiness

    @Inject constructor(projectBusiness: ProjectBusiness) {
        this.projectBusiness = projectBusiness
    }

    override fun onLoad() {
        /*todo onLoad
            show it is loading
            load projects in background
            display projects in foreground
         */
    }

    fun loadProjects() {
        //todo loadProjects
    }

    fun displayProjects(projects: List<Project>) {
        //todo displayProjects
    }
}
