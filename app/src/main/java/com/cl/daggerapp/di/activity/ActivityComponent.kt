package com.cl.daggerapp.di.activity

import com.cl.daggerapp.di.presentation.PresentationComponent
import com.cl.daggerapp.di.presentation.PresentationModule
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {
    fun newPresentationComponent(presentationModule: PresentationModule): PresentationComponent

}