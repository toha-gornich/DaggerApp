package com.cl.daggerapp

import android.app.Application
import com.cl.daggerapp.di.app.AppComponent
import com.cl.daggerapp.di.app.AppModule
import com.cl.daggerapp.di.app.DaggerAppComponent


class MyApplication: Application() {
    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }
    override fun onCreate() {
        super.onCreate()

    }

}
