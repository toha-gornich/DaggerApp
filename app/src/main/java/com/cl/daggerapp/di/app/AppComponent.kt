package com.cl.daggerapp.di.app

import android.app.Application
import com.cl.daggerapp.networking.StackoverflowApi
import dagger.Component


@AppScope
@Component(modules = [AppModule::class])
interface AppComponent {

    fun application():Application

    fun stackoverflowApi():StackoverflowApi
}