package com.cl.daggerapp.networking

import com.cl.daggerapp.questions.Question
import com.google.gson.annotations.SerializedName

class QuestionsListResponseSchema(@SerializedName("items") val questions: List<Question>)