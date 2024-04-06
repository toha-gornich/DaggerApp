package com.cl.daggerapp.di

import com.cl.daggerapp.questions.FetchQuestionDetailsUseCase
import com.cl.daggerapp.questions.FetchQuestionsUseCase
import com.cl.daggerapp.screens.common.dialogs.DialogsNavigator
import com.cl.daggerapp.screens.common.viewsmvc.ViewMvcFactory

class PresentationCompositionRoot(activityCompositionRoot: ActivityCompositionRoot) {
    private val fragmentManager = activityCompositionRoot.fragmentManager
    private val layoutInflater = activityCompositionRoot.layoutInflater
    private val stackoverflowApi = activityCompositionRoot.stackoverflowApi
    val screensNavigator = activityCompositionRoot.screensNavigator

    val dialogsNavigator get() = DialogsNavigator(fragmentManager)
    val viewMvcFactory get() = ViewMvcFactory(layoutInflater)
    val fetchQuestionsUseCase get() = FetchQuestionsUseCase(stackoverflowApi)
    val fetchQuestionDetailsUseCase get() = FetchQuestionDetailsUseCase(stackoverflowApi)

}