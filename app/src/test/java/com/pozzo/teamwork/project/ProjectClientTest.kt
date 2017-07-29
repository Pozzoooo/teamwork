package com.pozzo.teamwork.project

import com.pozzo.teamwork.BaseTest
import com.pozzo.teamwork.project.list.DaggerProjectListComponent
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

/**
 * todo THIS ARE INTEGRATION TESTS, they should be isolated from unit test
 *
 * @since 28/07/17.
 */
@RunWith(RobolectricTestRunner::class)
class ProjectClientTest: BaseTest() {
    private lateinit var projectClient: ProjectClient

    @Before
    fun setUp() {
        val appComponent = getAppComponent()
        val projectListComponent = DaggerProjectListComponent.builder()
                .appComponent(appComponent)
                .build()
        projectClient = projectListComponent.projectClient()
    }

    @Test
    fun shouldDownloadProjects() {
        val allProjects = projectClient.downloadAllProjects()
        Assert.assertTrue(allProjects.isNotEmpty())
    }
}