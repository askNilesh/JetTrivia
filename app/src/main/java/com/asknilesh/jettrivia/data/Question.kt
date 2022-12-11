package com.asknilesh.jettrivia.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Question(
  val category: String,
  val correct_answer: String,
  val incorrect_answers: List<String>,
  val question: String,
  var result: Boolean = false,
  var selectedAnswer: String = ""
) : Parcelable

@Parcelize
data class QuestionData(
  val question: List<Question>
) : Parcelable

