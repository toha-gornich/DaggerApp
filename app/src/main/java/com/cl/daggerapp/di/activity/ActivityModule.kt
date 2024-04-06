package com.cl.daggerapp.di.activity

import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.cl.daggerapp.di.app.AppComponent
import com.cl.daggerapp.screens.common.ScreensNavigator
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(
    val activity: AppCompatActivity,
    private val appComponent: AppComponent
) {


    @Provides
    fun activity() = activity
    @Provides
    @ActivityScope
    fun screensNavigator(activity: AppCompatActivity) = ScreensNavigator(activity)
    @Provides
    fun application() = appComponent.application()

    @Provides
    fun fragmentManager() = activity.supportFragmentManager

    @Provides

    fun stackoverflowApi() = appComponent.stackoverflowApi()

    @Provides

    fun layoutInflater(): LayoutInflater = LayoutInflater.from(activity)


}