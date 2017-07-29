package com.pozzo.teamwork.project

import com.pozzo.teamwork.architecture.model.Site
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

/**
 * @since 28/07/17.
 */
@Module
class ProjectModule {

    @Provides
    fun provideProjectApi(retrofitBuilder: Retrofit.Builder, site: Site): ProjectApi {
        return retrofitBuilder.baseUrl(site.baseUrl).build().create(ProjectApi::class.java)
    }

    @Provides
    fun provideProjectClient(projectApi: ProjectApi): ProjectClient {
        return ProjectClient(projectApi)
    }

    @Provides
    fun provideProjectBusiness(projectClient: ProjectClient): ProjectBusiness {
        return ProjectBusiness(projectClient)
    }
}
