package com.cl.daggerapp.screens.common

import androidx.appcompat.app.AppCompatActivity
import com.cl.daggerapp.common.di.activity.ActivityScope
import com.cl.daggerapp.screens.questiondetails.QuestionDetailsActivity
import javax.inject.Inject

class ScreensNavigatorImpl (private val activity: AppCompatActivity):ScreensNavigator {


    override fun navigationBack() {
        activity.onBackPressed()
    }

    override fun toQuestionDetails(questionId: String) {
        QuestionDetailsActivity.start(activity, questionId)

    }
}