package com.cl.daggerapp.screens.common.activities

import androidx.appcompat.app.AppCompatActivity
import com.cl.daggerapp.MyApplication
import com.cl.daggerapp.di.ActivityCompositionRoot
import com.cl.daggerapp.di.Injector
import com.cl.daggerapp.di.PresentationCompositionRoot

open class BaseActivity : AppCompatActivity() {


    private val appCompositionRoot get() = (application as MyApplication).appCompositionRoot
    private val activityCompositionRoot by lazy { ActivityCompositionRoot(this, appCompositionRoot) }
    private val compositionRoot by lazy { PresentationCompositionRoot(activityCompositionRoot)}

    protected val injector get() = Injector(compositionRoot)


}