package com.cl.daggerapp.di.presentation

import com.cl.daggerapp.screens.questiondetails.QuestionDetailsActivity
import com.cl.daggerapp.screens.questionslist.QuestionsListActivity
import dagger.Subcomponent


//In the 'modules =' list, you can specify multiple modules, it will be component 1 but it implements many services.
@PresentationScope
@Subcomponent( modules = [PresentationModule::class,UseCaseModule::class])
interface PresentationComponent {
    fun inject(activity: QuestionsListActivity)
    fun inject(activity: QuestionDetailsActivity)
}