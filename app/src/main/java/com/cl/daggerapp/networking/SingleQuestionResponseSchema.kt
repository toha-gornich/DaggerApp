package com.cl.daggerapp.networking
import com.cl.daggerapp.questions.QuestionWithBody
import com.google.gson.annotations.SerializedName

data class SingleQuestionResponseSchema(@SerializedName("items") val questions: List<QuestionWithBody>){

    val question: QuestionWithBody get() = questions[0]
}