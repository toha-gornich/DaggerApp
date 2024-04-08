package com.cl.daggerapp.screens.common.activities

import androidx.appcompat.app.AppCompatActivity
import com.cl.daggerapp.MyApplication
import com.cl.daggerapp.di.activity.ActivityModule

import com.cl.daggerapp.di.activity.DaggerActivityComponent
import com.cl.daggerapp.di.presentation.DaggerPresentationComponent
import com.cl.daggerapp.di.presentation.PresentationModule

open class BaseActivity: AppCompatActivity() {

    private val appCompositionRoot get() = (application as MyApplication).appComponent

    val activityComponent by lazy {
        DaggerActivityComponent.builder()
            .activityModule(ActivityModule(this, appCompositionRoot))
            .build()
    }

    private val presentationComponent by lazy {
        DaggerPresentationComponent.builder()
            .presentationModule(PresentationModule(activityComponent))
            .build()
    }

    protected val injector get() = presentationComponent

}