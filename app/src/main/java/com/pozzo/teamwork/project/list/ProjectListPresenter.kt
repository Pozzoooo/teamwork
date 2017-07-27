package com.pozzo.teamwork.project.list

import com.pozzo.teamwork.architecture.mvp.BasePresenter
import com.pozzo.teamwork.project.ProjectApi

import javax.inject.Inject

import retrofit2.Retrofit

/**
 * @since 27/07/17.
 */
class ProjectListPresenter: BasePresenter<ProjectListView> {
    var projectApi: ProjectApi

    @Inject constructor(retrofitBuilder: Retrofit.Builder) {
        //todo extract base url
        projectApi = retrofitBuilder.baseUrl("https://yat.teamwork.com/").build().create(ProjectApi::class.java)
    }

    override fun onLoad() {
        //todo its here for test only
        object: Thread() {
            override fun run() {
                try {
                    val call = projectApi.projects()
                    val response = call.execute()
                    response.body()?.projects?.forEach {
                        println(it.name)
                    }
                } catch (e: Throwable) {
                    e.printStackTrace()
                    println(e.message)
                }
            }
        }.start()
    }
}
