package com.cl.daggerapp.screens.common.activities

import androidx.appcompat.app.AppCompatActivity
import com.cl.daggerapp.MyApplication
import com.cl.daggerapp.di.activity.ActivityModule
import com.cl.daggerapp.di.presentation.PresentationModule
import com.cl.daggerapp.di.presentation.UseCaseModule

open class BaseActivity : AppCompatActivity() {

    private val appCompositionRoot get() = (application as MyApplication).appComponent

    private val activityComponent by lazy {
        appCompositionRoot.newActivityComponent(ActivityModule(this))
    }
//    There is a convention where it can be issued
    private val presentationComponent by lazy {
        activityComponent.newPresentationComponent(PresentationModule(),UseCaseModule())
    }

    protected val injector get() = presentationComponent

}