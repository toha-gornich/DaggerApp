package com.cl.daggerapp.common.di.activity

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import com.cl.daggerapp.common.di.presentation.PresentationComponent
import dagger.BindsInstance
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {

//    You can remove the parameters from the function and it will work, there is a Dagger convention
    fun newPresentationComponent(): PresentationComponent

    @Subcomponent.Builder
    interface Builder{
        //inject activity right into component builders
        @BindsInstance fun activity(activity: AppCompatActivity):Builder
        fun activityModule(activityModule: ActivityModule):Builder
        fun build():ActivityComponent
    }

}