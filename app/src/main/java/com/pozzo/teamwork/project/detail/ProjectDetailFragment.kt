package com.pozzo.teamwork.project.detail

import android.os.Bundle
import android.support.design.widget.CollapsingToolbarLayout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.pozzo.teamwork.R
import com.pozzo.teamwork.architecture.mvp.BaseFragment
import com.pozzo.teamwork.project.model.Project
import com.squareup.picasso.Picasso

/**
 * @see com.pozzo.teamwork.project.list.ProjectListActivity
 * @see Project
 * @see ProjectDetailFragment
 * @since 29/07/17.
 */
class ProjectDetailFragment: BaseFragment() {
    companion object {
        const val PARAM_PROJECT = "project"

        fun newInstance(project: Project): ProjectDetailFragment {
            val arguments = Bundle()
            arguments.putParcelable(ProjectDetailFragment.PARAM_PROJECT, project)

            val fragment = ProjectDetailFragment()
            fragment.arguments = arguments
            return fragment
        }
    }

    private lateinit var project: Project

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup,
                              savedInstanceState: Bundle?): View {
        if (arguments.containsKey(PARAM_PROJECT)) {
            project = arguments.getParcelable(PARAM_PROJECT)

            val appBarLayout: CollapsingToolbarLayout = activity.findViewById(R.id.toolbar_layout)
            appBarLayout.title = project.name

            val projectLogo: ImageView = activity.findViewById(R.id.project_logo)
            if (project.logo?.isEmpty() == false) {
                Picasso.with(activity)
                        .load(project.logo)
                        .noPlaceholder()
                        .into(projectLogo)
            }
        }

        val rootView = inflater.inflate(R.layout.project_detail, container, false)
        rootView.findViewById<TextView>(R.id.project_detail).text = project.description
        return rootView
    }
}
