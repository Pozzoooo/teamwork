package com.pozzo.teamwork.project.list

import com.pozzo.teamwork.architecture.mvp.BasePresenter
import com.pozzo.teamwork.project.ProjectBusiness
import com.pozzo.teamwork.project.model.Project
import javax.inject.Inject

/**
 * @since 27/07/17.
 */
class ProjectListPresenter @Inject constructor(private var projectBusiness: ProjectBusiness) :
        BasePresenter<ProjectListView>() {
    private var allProjects: List<Project> = ArrayList()

    override fun onLoad() {
        runInBackground(this::loadProjects, { display(allProjects) })
    }

    fun loadProjects() {
        allProjects = projectBusiness.getAllProjects()
    }

    fun display(projects: List<Project>) {
        getView()?.displayProjectList(projects)
    }

    fun selectProject(project: Project) {
        getView()?.startDetail(project)
    }
}
