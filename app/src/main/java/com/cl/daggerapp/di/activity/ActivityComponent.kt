package com.cl.daggerapp.di.activity

import android.app.Application
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.cl.daggerapp.networking.StackoverflowApi
import com.cl.daggerapp.screens.common.ScreensNavigator
import dagger.Component

@ActivityScope
@Component(modules = [ActivityModule::class])
interface ActivityComponent {

    fun activity():AppCompatActivity
    fun application():Application
    fun fragmentManager():FragmentManager
    fun stackoverflowApi():StackoverflowApi
    fun layoutInflater(): LayoutInflater
    fun screensNavigator():ScreensNavigator
}