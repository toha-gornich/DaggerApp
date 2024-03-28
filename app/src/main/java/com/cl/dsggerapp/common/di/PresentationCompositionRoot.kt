package com.cl.dsggerapp.common.di

import com.cl.dsggerapp.questions.FetchQuestionDetailsUseCase
import com.cl.dsggerapp.questions.FetchQuestionsUseCase
import com.cl.dsggerapp.screens.common.dialogs.DialogsNavigator
import com.cl.dsggerapp.screens.common.viewsmvc.ViewMvcFactory

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