package com.cl.dsggerapp.networking

import com.cl.dsggerapp.questions.Question
import com.google.gson.annotations.SerializedName

class QuestionsListResponseSchema(@SerializedName("items") val questions: List<Question>)