package com.cl.daggerapp.screens.common.activities

import androidx.appcompat.app.AppCompatActivity
import com.cl.daggerapp.MyApplication
import com.cl.daggerapp.common.di.activity.ActivityModule

open class BaseActivity : AppCompatActivity() {

    private val appCompositionRoot get() = (application as MyApplication).appComponent

    val activityComponent by lazy {
        appCompositionRoot.newActivityComponentBuilder()
            .activity(this)
            .build()
    }

    //    There is a convention where it can be issued
    private val presentationComponent by lazy {
        activityComponent.newPresentationComponent()
    }

    protected val injector get() = presentationComponent

}