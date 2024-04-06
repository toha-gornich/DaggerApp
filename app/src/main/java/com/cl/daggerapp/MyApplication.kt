package com.cl.daggerapp

import android.app.Application
import com.cl.daggerapp.di.AppCompositionRoot


class MyApplication: Application() {
    lateinit var appCompositionRoot:AppCompositionRoot
    override fun onCreate() {
        appCompositionRoot = AppCompositionRoot(this)
        super.onCreate()
    }

}
