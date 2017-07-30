package com.pozzo.teamwork.project.detail

import com.pozzo.teamwork.architecture.mvp.BasePresenter
import com.pozzo.teamwork.project.model.Project
import javax.inject.Inject

/**
 * @since 30/07/17.
 */
class ProjectDetailPresenter @Inject constructor(): BasePresenter<ProjectDetailView>() {

    override fun onLoad() {
    }

    fun openProject(project: Project) {
        getView()?.displayProject(project)
    }
}
