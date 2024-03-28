package com.cl.dsggerapp.questions

import com.cl.dsggerapp.networking.StackoverflowApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.coroutines.cancellation.CancellationException

class FetchQuestionDetailsUseCase(private val stackoverflowApi: StackoverflowApi) {


    sealed class Result {
        data class Success(val question: String?) : Result()
        object Failure : Result()
    }


    suspend fun fetchDetailQuestion(questionId: String?): Result {
        return withContext(Dispatchers.IO) {
            try {
                val response = stackoverflowApi.questionDetails(questionId)
                if (response.isSuccessful && response.body() != null) {
                    return@withContext Result.Success(response.body()!!.question.body)
                } else {
                    return@withContext Result.Failure
                }
            } catch (t: Throwable) {
                if (t !is CancellationException) {
                    return@withContext Result.Failure
                } else {
                    throw t
                }
            }
        }
    }
}