package com.pozzo.teamwork.project.detail

import com.pozzo.teamwork.architecture.injection.ActivityScope
import com.pozzo.teamwork.architecture.injection.AppComponent
import dagger.Component

/**
 * @since 27/07/17.
 */
@ActivityScope
@Component(dependencies = arrayOf(AppComponent::class),
        modules = arrayOf(ProjectDetailModule::class))
interface ProjectDetailComponent {
    fun inject(activity: ProjectDetailActivity)
}
