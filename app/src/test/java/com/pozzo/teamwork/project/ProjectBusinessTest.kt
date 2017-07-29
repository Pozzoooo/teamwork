package com.pozzo.teamwork.project

import com.pozzo.teamwork.BaseTest
import com.pozzo.teamwork.project.model.Project
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

/**
 * @since 28/07/17.
 */
class ProjectBusinessTest: BaseTest() {
    private lateinit var projectBusiness: ProjectBusiness
    private lateinit var mockedProjectList: List<Project>

    @Before
    fun setUp() {
        mockedProjectList = listOf(Project("1", "logo", "project name", "description", true))

        val projectClient = Mockito.mock(ProjectClient::class.java)
        Mockito.`when`(projectClient.downloadAllProjects()).thenReturn(mockedProjectList)

        projectBusiness = ProjectBusiness(projectClient)
    }

    @Test
    fun shouldGetAllDownloadedProjects() {
        val allProjects = projectBusiness.getAllProjects()
        assertEquals(mockedProjectList.size, allProjects.size)
        assertEquals(mockedProjectList.get(0), allProjects.get(0))
    }
}
