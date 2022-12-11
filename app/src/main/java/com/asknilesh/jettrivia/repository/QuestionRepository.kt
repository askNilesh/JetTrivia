package com.asknilesh.jettrivia.repository

import com.asknilesh.jettrivia.data.QuestionResponse
import com.asknilesh.jettrivia.network.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class QuestionRepository @Inject constructor(
  private val apiService: ApiService
) {
  suspend fun getQuestions(): Response<QuestionResponse> {
    return withContext(Dispatchers.IO) {
      return@withContext apiService.getQuestions()
    }
  }
}