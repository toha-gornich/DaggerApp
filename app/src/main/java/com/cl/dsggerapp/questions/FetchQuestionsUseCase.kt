package com.cl.dsggerapp.questions

import com.cl.dsggerapp.networking.StackoverflowApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.coroutines.CancellationException

class FetchQuestionsUseCase(
    private val stackoverflowApi: StackoverflowApi
){

sealed class Result {
    data class Success(val questions: List<Question>) : Result()
    object Failure : Result()
}


suspend fun fetchLatestQuestions(): Result {
    return withContext(Dispatchers.IO) {
        try {
            val response = stackoverflowApi.lastActiveQuestions(20)
            if (response.isSuccessful && response.body() != null) {
                return@withContext Result.Success(response.body()!!.questions)
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