package com.cl.dsggerapp

import android.app.Application
import com.cl.dsggerapp.common.composition.AppCompositionRoot


class MyApplication: Application() {
    lateinit var appCompositionRoot:AppCompositionRoot
    override fun onCreate() {
        appCompositionRoot = AppCompositionRoot()
        super.onCreate()
    }

}
