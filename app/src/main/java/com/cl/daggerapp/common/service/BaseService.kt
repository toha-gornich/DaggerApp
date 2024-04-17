package com.cl.daggerapp.common.service

import android.app.Service
import com.cl.daggerapp.MyApplication
import com.cl.daggerapp.common.di.service.ServiceModule

abstract class BaseService: Service() {
    private val appCompositionRoot get() = (application as MyApplication).appComponent

    private val serviceComponent by lazy {
        appCompositionRoot.newServiceComponent(ServiceModule(this))
    }
}