package com.cl.daggerapp.common.di.activity

import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import dagger.Module
import dagger.Provides


@Module
class ActivityModule(private val activity: AppCompatActivity) {


    @Provides
    fun activity() = activity


    @Provides
    fun fragmentManager() = activity.supportFragmentManager


    @Provides

    fun layoutInflater(): LayoutInflater = LayoutInflater.from(activity)


}