package com.pozzo.teamwork.project.list

import android.os.Bundle
import com.pozzo.teamwork.architecture.injection.AppComponent
import com.pozzo.teamwork.architecture.mvp.BaseActivity
import com.pozzo.teamwork.project.DaggerProjectListComponent
import javax.inject.Inject

/**
 * @since 27/07/17.
 */
class ProjectListActivity: BaseActivity(), ProjectListView {
    @Inject lateinit var presenter: ProjectListPresenter

    override fun onCreateComponent(appComponent: AppComponent) {
        DaggerProjectListComponent.builder()
                .appComponent(appComponent)
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
}