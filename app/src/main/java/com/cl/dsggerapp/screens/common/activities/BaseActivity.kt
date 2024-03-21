package com.cl.dsggerapp.screens.common.activities

import androidx.appcompat.app.AppCompatActivity
import com.cl.dsggerapp.MyApplication
import com.cl.dsggerapp.common.composition.ActivityCompositionRoot

open class BaseActivity : AppCompatActivity() {


    private val appCompositionRoot get() = (application as MyApplication).appCompositionRoot
    val compositionRoot by lazy { ActivityCompositionRoot(this, appCompositionRoot) }
}