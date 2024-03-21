package com.cl.dsggerapp.common.composition

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.cl.dsggerapp.questions.FetchQuestionDetailsUseCase
import com.cl.dsggerapp.questions.FetchQuestionsUseCase
import com.cl.dsggerapp.screens.common.ScreensNavigator
import com.cl.dsggerapp.screens.common.dialogs.DialogsNavigator

class ActivityCompositionRoot(
    private val activity: AppCompatActivity,
    private val appCompositionRoot: AppCompositionRoot
) {

    val screensNavigator by lazy {
        ScreensNavigator(activity)
    }

    private val fragmentManager = activity.supportFragmentManager
    val dialogsNavigator get() = DialogsNavigator(fragmentManager)

    private val stackoverflowApi get() = appCompositionRoot.stackoverflowApi
    val fetchQuestionsUseCase get() = FetchQuestionsUseCase(stackoverflowApi)
    val fetchQuestionDetailsUseCase get() = FetchQuestionDetailsUseCase(stackoverflowApi)

}