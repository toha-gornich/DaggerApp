package com.cl.daggerapp.common.di.activity

import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.cl.daggerapp.screens.common.ScreensNavigator
import com.cl.daggerapp.screens.common.ScreensNavigatorImpl
import dagger.Module
import dagger.Provides


@Module
object ActivityModule {
    @ActivityScope
    @Provides
    fun screensNavigator(activity: AppCompatActivity):ScreensNavigator = ScreensNavigatorImpl(activity)

    @Provides
    fun fragmentManager(activity: AppCompatActivity) = activity.supportFragmentManager

    @Provides
    fun layoutInflater(activity: AppCompatActivity): LayoutInflater =
        LayoutInflater.from(activity)

}