package com.cl.daggerapp.screens.common

import androidx.appcompat.app.AppCompatActivity
import com.cl.daggerapp.common.di.activity.ActivityScope
import com.cl.daggerapp.screens.questiondetails.QuestionDetailsActivity
import javax.inject.Inject

@ActivityScope
class ScreensNavigator @Inject constructor(private val activity: AppCompatActivity) {


    fun navigationBack() {
        activity.onBackPressed()
    }

    fun toQuestionDetails(questionId: String) {
        QuestionDetailsActivity.start(activity, questionId)

    }
}