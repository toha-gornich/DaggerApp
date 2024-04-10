package com.cl.daggerapp.di.activity

import com.cl.daggerapp.di.presentation.PresentationComponent
import com.cl.daggerapp.di.presentation.PresentationModule
import com.cl.daggerapp.di.presentation.UseCaseModule
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {

//    You can remove the parameters from the function and it will work, there is a Dagger convention
    fun newPresentationComponent(presentationModule: PresentationModule, useCaseModule: UseCaseModule): PresentationComponent

}