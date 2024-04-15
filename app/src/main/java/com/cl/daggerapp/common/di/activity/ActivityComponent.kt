package com.cl.daggerapp.common.di.activity

import com.cl.daggerapp.common.di.presentation.PresentationComponent
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {

//    You can remove the parameters from the function and it will work, there is a Dagger convention
    fun newPresentationComponent(): PresentationComponent

}