package com.pozzo.teamwork.project.list

import com.pozzo.teamwork.architecture.injection.ActivityScope
import com.pozzo.teamwork.architecture.injection.AppComponent

import dagger.Component

/**
 * @since 27/07/17.
 */
@ActivityScope
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(ProjectListModule::class))
interface ProjectListComponent {
    fun inject(activity: ProjectListActivity)
}
