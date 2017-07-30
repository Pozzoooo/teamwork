package com.pozzo.teamwork.project.model

import com.pozzo.teamwork.architecture.model.TeamworkResponse

/**
 * A list of Projects, as by returned by Teamwork web service.
 *
 * @since 27/07/17.
 */
class Projects: TeamworkResponse() {
    lateinit var projects: List<Project>
}
