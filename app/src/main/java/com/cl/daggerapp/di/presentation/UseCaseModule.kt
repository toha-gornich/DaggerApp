package com.cl.daggerapp.di.presentation

import com.cl.daggerapp.networking.StackoverflowApi
import com.cl.daggerapp.questions.FetchQuestionDetailsUseCase
import com.cl.daggerapp.questions.FetchQuestionsUseCase
import dagger.Module
import dagger.Provides


@Module
class UseCaseModule {
    @Provides
    fun fetchQuestionsUseCase(stackoverflowApi: StackoverflowApi) =
        FetchQuestionsUseCase(stackoverflowApi)

    @Provides
    fun fetchQuestionDetailsUseCase(stackoverflowApi: StackoverflowApi) =
        FetchQuestionDetailsUseCase(stackoverflowApi)
}