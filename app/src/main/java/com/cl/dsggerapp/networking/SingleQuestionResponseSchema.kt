package com.cl.dsggerapp.networking
import com.cl.dsggerapp.questions.QuestionWithBody
import com.google.gson.annotations.SerializedName

data class SingleQuestionResponseSchema(@SerializedName("items") val questions: List<QuestionWithBody>){

    val question: QuestionWithBody get() = questions[0]
}