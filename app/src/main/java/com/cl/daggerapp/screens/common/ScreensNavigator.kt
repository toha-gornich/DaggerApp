package com.cl.daggerapp.screens.common

import android.app.Activity
import com.cl.daggerapp.screens.questiondetails.QuestionDetailsActivity

class ScreensNavigator(private val activity: Activity) {


    fun navigationBack() {
        activity.onBackPressed()
    }

    fun toQuestionDetails(questionId: String) {
        QuestionDetailsActivity.start(activity, questionId)

    }
}