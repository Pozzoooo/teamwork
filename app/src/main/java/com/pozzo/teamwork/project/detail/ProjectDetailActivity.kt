package com.pozzo.teamwork.project.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.view.MenuItem
import android.widget.Toolbar
import com.pozzo.teamwork.R
import com.pozzo.teamwork.architecture.injection.AppComponent
import com.pozzo.teamwork.architecture.mvp.BaseActivity
import com.pozzo.teamwork.project.list.DaggerProjectDetailComponent
import com.pozzo.teamwork.project.list.ProjectListActivity
import com.pozzo.teamwork.project.model.Project

/**
 * @since 29/07/17.
 */
class ProjectDetailActivity: BaseActivity() {

    companion object {
        fun newIntent(context: Context, project: Project): Intent {
            val intent = Intent(context, ProjectDetailActivity::class.java)
            intent.putExtra(ProjectDetailFragment.PARAM_PROJECT, project)
            return intent
        }
    }

    override fun onCreateComponent(appComponent: AppComponent) {
        DaggerProjectDetailComponent.builder()
                .appComponent(appComponent)
                .build()
                .inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_project_detail)
        val toolbar: Toolbar = findViewById(R.id.detail_toolbar)
        setActionBar(toolbar)

        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            //todo is there enough time to do something here?
            Snackbar.make(view, "Not implemented yet", Snackbar.LENGTH_LONG)
                    .setAction("Undo", null).show()
        }

        val actionBar = actionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

        if (savedInstanceState == null) {
            val project = intent.getParcelableExtra<Project>(ProjectDetailFragment.PARAM_PROJECT)
            val fragment = ProjectDetailFragment.newInstance(project)
            addFragment(fragment, R.id.project_detail_container)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == android.R.id.home) {
            navigateUpTo(Intent(this, ProjectListActivity::class.java))
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
