package com.cl.daggerapp.di.app

import com.cl.daggerapp.di.activity.ActivityComponent
import com.cl.daggerapp.di.activity.ActivityModule
import dagger.Component


@AppScope
@Component(modules = [AppModule::class])
interface AppComponent {

    fun newActivityComponent(activityModule: ActivityModule):ActivityComponent
}