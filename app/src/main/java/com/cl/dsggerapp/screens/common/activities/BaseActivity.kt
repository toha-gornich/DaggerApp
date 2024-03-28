package com.cl.dsggerapp.screens.common.activities

import androidx.appcompat.app.AppCompatActivity
import com.cl.dsggerapp.MyApplication
import com.cl.dsggerapp.common.di.ActivityCompositionRoot
import com.cl.dsggerapp.common.di.Injector
import com.cl.dsggerapp.common.di.PresentationCompositionRoot

open class BaseActivity : AppCompatActivity() {


    private val appCompositionRoot get() = (application as MyApplication).appCompositionRoot
    private val activityCompositionRoot by lazy { ActivityCompositionRoot(this, appCompositionRoot) }
    private val compositionRoot by lazy { PresentationCompositionRoot(activityCompositionRoot)}

    protected val injector get() = Injector(compositionRoot)


}