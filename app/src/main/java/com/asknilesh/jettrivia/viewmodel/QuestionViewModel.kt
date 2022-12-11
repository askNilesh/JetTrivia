package com.asknilesh.jettrivia.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.asknilesh.jettrivia.data.Question
import com.asknilesh.jettrivia.repository.QuestionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class QuestionViewModel @Inject constructor(
  private val questionRepository: QuestionRepository
) : ViewModel() {
  var showLoading = mutableStateOf(false)
  val questionList = mutableStateListOf<Question>()

  suspend fun getQuestions() {
    showLoading.value = true
    val response = questionRepository.getQuestions()
    if (response.isSuccessful) {
      showLoading.value = false
      questionList.clear()
      questionList.addAll(response.body()?.results ?: emptyList())
    } else {
      showLoading.value = false
    }
  }
}