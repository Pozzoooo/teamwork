package com.pozzo.teamwork.project.list

import com.pozzo.teamwork.architecture.injection.ActivityScope
import com.pozzo.teamwork.architecture.injection.AppComponent
import com.pozzo.teamwork.project.detail.ProjectDetailActivity
import dagger.Component

/**
 * @since 27/07/17.
 */
@ActivityScope
@Component(dependencies = arrayOf(AppComponent::class))
interface ProjectDetailComponent {
    fun inject(activity: ProjectDetailActivity)
}
