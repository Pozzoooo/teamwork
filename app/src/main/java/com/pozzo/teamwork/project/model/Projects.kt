package com.pozzo.teamwork.project.model

import com.pozzo.teamwork.architecture.network.TwResponse

/**
 * @since 27/07/17.
 */
class Projects: TwResponse() {
    lateinit var projects: List<Project>
}
