package com.pozzo.teamwork.project.list

import android.os.Bundle
import com.pozzo.teamwork.architecture.injection.AppComponent
import com.pozzo.teamwork.architecture.mvp.BaseActivity
import com.pozzo.teamwork.project.ProjectModule
import com.pozzo.teamwork.project.model.Project
import javax.inject.Inject

/**
 * understand how rotation is going to be handled here and the inject life cycle
 *
 * @since 27/07/17.
 */
class ProjectListActivity: BaseActivity(), ProjectListView {
    @Inject lateinit var presenter: ProjectListPresenter

    override fun onCreateComponent(appComponent: AppComponent) {
        DaggerProjectListComponent.builder()
                .appComponent(appComponent)
                .projectModule(ProjectModule())
                .build()
                .inject(this);
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter.takeView(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.dropView()
    }

    override fun displayProjectList(projectList: List<Project>) {
        TODO("not implemented")
    }

    override fun selectProject(project: Project) {
        TODO("not implemented")
    }
}
