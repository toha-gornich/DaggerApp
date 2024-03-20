package com.cl.dsggerapp

import android.app.Application
import com.cl.dsggerapp.networking.StackoverflowApi
import com.cl.dsggerapp.questions.FetchQuestionDetailsUseCase
import com.cl.dsggerapp.questions.FetchQuestionsUseCase
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MyApplication: Application() {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    private val stackoverflowApi:StackoverflowApi = retrofit.create(StackoverflowApi::class.java)

    val fetchQuestionsUseCase get() = FetchQuestionsUseCase(stackoverflowApi)
    val fetchQuestionDetailsUseCase get() = FetchQuestionDetailsUseCase(stackoverflowApi)
    override fun onCreate() {
        super.onCreate()
    }

}
