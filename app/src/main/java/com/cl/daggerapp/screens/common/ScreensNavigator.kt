package com.cl.daggerapp.screens.common


interface ScreensNavigator {


    fun navigationBack()

    fun toQuestionDetails(questionId: String)
}