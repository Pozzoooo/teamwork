package com.pozzo.teamwork.project.detail

import com.pozzo.teamwork.architecture.mvp.BaseView
import com.pozzo.teamwork.project.model.Project

/**
 * @since 30/07/17.
 */
interface ProjectDetailView: BaseView {
    fun displayProject(project: Project)
}
