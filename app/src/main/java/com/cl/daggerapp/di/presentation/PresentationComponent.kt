package com.cl.daggerapp.di.presentation

import com.cl.daggerapp.screens.questiondetails.QuestionDetailsActivity
import com.cl.daggerapp.screens.questionslist.QuestionsListActivity
import dagger.Subcomponent


@PresentationScope
@Subcomponent( modules = [PresentationModule::class])
interface PresentationComponent {
    fun inject(activity: QuestionsListActivity)
    fun inject(activity: QuestionDetailsActivity)
}