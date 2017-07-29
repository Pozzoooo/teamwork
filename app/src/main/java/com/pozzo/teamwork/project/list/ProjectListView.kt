package com.pozzo.teamwork.project.list

import com.pozzo.teamwork.architecture.mvp.BaseView
import com.pozzo.teamwork.project.model.Project

/**
 * @since 27/07/17.
 */
interface ProjectListView: BaseView {
    fun displayProjectList(projectList: List<Project>)
    fun selectProject(project: Project)
    fun startDetail(project: Project)
}
