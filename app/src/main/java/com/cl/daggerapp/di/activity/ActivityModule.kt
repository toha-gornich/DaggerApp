package com.cl.daggerapp.di.activity

import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.cl.daggerapp.screens.common.ScreensNavigator
import dagger.Module
import dagger.Provides


@Module
class ActivityModule(private val activity: AppCompatActivity) {


    @Provides
    fun activity() = activity
    @Provides
    @ActivityScope
    fun screensNavigator(activity: AppCompatActivity) = ScreensNavigator(activity)


    @Provides
    fun fragmentManager() = activity.supportFragmentManager


    @Provides

    fun layoutInflater(): LayoutInflater = LayoutInflater.from(activity)


}