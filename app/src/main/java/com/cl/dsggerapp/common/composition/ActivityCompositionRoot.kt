package com.cl.dsggerapp.common.composition

import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.cl.dsggerapp.screens.common.ScreensNavigator

class ActivityCompositionRoot(
    private val activity: AppCompatActivity,
    private val appCompositionRoot: AppCompositionRoot
) {

    val screensNavigator by lazy {
        ScreensNavigator(activity)
    }

    val fragmentManager = activity.supportFragmentManager

    val stackoverflowApi get() = appCompositionRoot.stackoverflowApi

    val layoutInflater: LayoutInflater get() = LayoutInflater.from(activity)


}