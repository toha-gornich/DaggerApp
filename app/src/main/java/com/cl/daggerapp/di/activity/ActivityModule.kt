package com.cl.daggerapp.di.activity

import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent


@Module
@InstallIn(ActivityComponent::class)
class ActivityModule(private val activity: AppCompatActivity) {


    @Provides
    fun activity() = activity


    @Provides
    fun fragmentManager() = activity.supportFragmentManager


    @Provides

    fun layoutInflater(): LayoutInflater = LayoutInflater.from(activity)


}