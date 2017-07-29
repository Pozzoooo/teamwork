package com.pozzo.teamwork.project.list

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toolbar
import com.pozzo.teamwork.R
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
    private var isTwoPane: Boolean = false

    override fun onCreateComponent(appComponent: AppComponent) {
        DaggerProjectListComponent.builder()
                .appComponent(appComponent)
                .projectModule(ProjectModule())
                .build()
                .inject(this);
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_project_list)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setActionBar(toolbar)
        toolbar.title = title

        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            //todo is there enough time to do something here?
            Snackbar.make(view, "Not implemented yet", Snackbar.LENGTH_LONG)
                    .setAction("Undo", null).show()
        }

        if (findViewById<View>(R.id.project_detail_container) != null) {
            isTwoPane = true
        }

        presenter.takeView(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.dropView()
    }

    override fun displayProjectList(projectList: List<Project>) {
        val recyclerView: RecyclerView = findViewById(R.id.project_list)
        recyclerView.adapter = ProjectListAdapter(projectList, isTwoPane, fragmentManager)
    }

    override fun selectProject(project: Project) {
        TODO("not implemented")
    }
}
