package com.asknilesh.jettrivia.network

import com.asknilesh.jettrivia.data.QuestionResponse
import retrofit2.Response
import retrofit2.http.GET
interface ApiService {
  @GET("api.php?amount=10&category=11&difficulty=easy&type=multiple")
  suspend
  fun getQuestions(): Response<QuestionResponse>
}