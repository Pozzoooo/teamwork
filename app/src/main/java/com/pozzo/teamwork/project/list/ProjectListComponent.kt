package com.pozzo.teamwork.project.list

import com.pozzo.teamwork.architecture.injection.ActivityScope
import com.pozzo.teamwork.architecture.injection.AppComponent
import com.pozzo.teamwork.project.ProjectClient
import com.pozzo.teamwork.project.ProjectModule
import dagger.Component

/**
 * @since 27/07/17.
 */
@ActivityScope
@Component(dependencies = arrayOf(AppComponent::class),
        modules = arrayOf(ProjectListModule::class, ProjectModule::class))
interface ProjectListComponent {
    fun inject(activity: ProjectListActivity)
    fun projectClient(): ProjectClient
}
