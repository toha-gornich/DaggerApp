package com.cl.dsggerapp.screens.common.activities

import androidx.appcompat.app.AppCompatActivity
import com.cl.dsggerapp.MyApplication
import com.cl.dsggerapp.common.composition.ActivityCompositionRoot
import com.cl.dsggerapp.common.composition.PresentationCompositionRoot

open class BaseActivity : AppCompatActivity() {


    private val appCompositionRoot get() = (application as MyApplication).appCompositionRoot
    private val activityCompositionRoot by lazy { ActivityCompositionRoot(this, appCompositionRoot) }
    protected val compositionRoot by lazy { PresentationCompositionRoot(activityCompositionRoot)}


}