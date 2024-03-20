package com.cl.dsggerapp.screens.common

import android.app.Activity
import com.cl.dsggerapp.screens.questiondetails.QuestionDetailsActivity

class ScreensNavigator(private val activity: Activity) {


    fun navigationBack() {
        activity.onBackPressed()
    }

    fun toQuestionDetails(questionId: String) {
        QuestionDetailsActivity.start(activity, questionId)

    }
}