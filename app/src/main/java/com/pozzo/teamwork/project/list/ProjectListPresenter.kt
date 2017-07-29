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
    private var allProjects: List<Project> = ArrayList<Project>()

    @Inject constructor(projectBusiness: ProjectBusiness) {
        this.projectBusiness = projectBusiness
    }

    override fun onLoad() {
        runInBackground(this::loadProjects, { display(allProjects) })
    }

    fun loadProjects() {
        allProjects = projectBusiness.getAllProjects()
    }

    fun display(projects: List<Project>) {
        getView()?.displayProjectList(projects)
    }
}
