package com.pozzo.teamwork.project.list

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toolbar
import com.pozzo.teamwork.R
import com.pozzo.teamwork.architecture.injection.AppComponent
import com.pozzo.teamwork.architecture.mvp.BaseActivity
import com.pozzo.teamwork.project.ProjectModule
import com.pozzo.teamwork.project.detail.ProjectDetailActivity
import com.pozzo.teamwork.project.detail.ProjectDetailFragment
import com.pozzo.teamwork.project.model.Project
import javax.inject.Inject

/**
 * @see Project
 * @since 27/07/17.
 */
class ProjectListActivity: BaseActivity(), ProjectListView {
    @Inject lateinit var presenter: ProjectListPresenter
    private var isTwoPane: Boolean = false
    private lateinit var refreshLayout: SwipeRefreshLayout

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

        refreshLayout = findViewById(R.id.refresh_layout)
        refreshLayout.isEnabled = false

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
        recyclerView.adapter = ProjectListAdapter(projectList, this)
    }

    override fun selectProject(project: Project) {
        presenter.selectProject(project)
    }

    override fun startDetail(project: Project) {
        if (isTwoPane) {
            val fragment = ProjectDetailFragment.newInstance(project)
            replaceFragment(fragment, R.id.project_detail_container)
        } else {
            val intent = ProjectDetailActivity.newIntent(this, project)
            startActivity(intent)
        }
    }

    override fun showLoading() {
        refreshLayout.isRefreshing = true
    }

    override fun hideLoading() {
        refreshLayout.isRefreshing = false
    }
}
