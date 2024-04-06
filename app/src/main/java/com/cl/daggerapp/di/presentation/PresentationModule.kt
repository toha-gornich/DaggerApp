package com.cl.daggerapp.di.presentation

import android.view.LayoutInflater
import androidx.fragment.app.FragmentManager
import com.cl.daggerapp.di.activity.ActivityComponent
import com.cl.daggerapp.networking.StackoverflowApi
import com.cl.daggerapp.questions.FetchQuestionDetailsUseCase
import com.cl.daggerapp.questions.FetchQuestionsUseCase
import com.cl.daggerapp.screens.common.dialogs.DialogsNavigator
import com.cl.daggerapp.screens.common.viewsmvc.ViewMvcFactory
import dagger.Module
import dagger.Provides

@Module
class PresentationModule(private val activityComponent: ActivityComponent) {
    @Provides
    fun layoutInflater() = activityComponent.layoutInflater()

    @Provides
    fun fragmentManager() = activityComponent.fragmentManager()

    @Provides
    fun activity() = activityComponent.activity()
    @Provides
    fun stackoverflowApi() = activityComponent.stackoverflowApi()

    @Provides
    fun screensNavigator() = activityComponent.screensNavigator()

    @Provides
    fun dialogsNavigator(fragmentManager: FragmentManager) = DialogsNavigator(fragmentManager)

    @Provides
    fun viewMvcFactory(layoutInflater: LayoutInflater) = ViewMvcFactory(layoutInflater)

    @Provides
    fun fetchQuestionsUseCase(stackoverflowApi: StackoverflowApi) =
        FetchQuestionsUseCase(stackoverflowApi)

    @Provides
    fun fetchQuestionDetailsUseCase(stackoverflowApi: StackoverflowApi) =
        FetchQuestionDetailsUseCase(stackoverflowApi)

}