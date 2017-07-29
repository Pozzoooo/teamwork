package com.pozzo.teamwork

import com.pozzo.teamwork.architecture.App
import com.pozzo.teamwork.architecture.injection.AppComponent
import com.pozzo.teamwork.architecture.injection.AppModule
import com.pozzo.teamwork.architecture.injection.DaggerAppComponent
import org.mockito.Mockito

/**
 * @since 28/07/17.
 */
open class BaseTest {
   fun getAppComponent(): AppComponent {
       val app = Mockito.mock(App::class.java)

       return DaggerAppComponent.builder()
               .appModule(AppModule(app))
               .build()
   }
}
