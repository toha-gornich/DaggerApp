package com.cl.daggerapp.common.di.app

import com.cl.daggerapp.common.di.activity.ActivityComponent
import com.cl.daggerapp.common.di.activity.ActivityModule
import com.cl.daggerapp.common.di.service.ServiceComponent
import com.cl.daggerapp.common.di.service.ServiceModule
import dagger.Component


@AppScope
@Component(modules = [AppModule::class])
interface AppComponent {

    fun newActivityComponent(activityModule: ActivityModule): ActivityComponent
    fun newServiceComponent(service: ServiceModule): ServiceComponent
}