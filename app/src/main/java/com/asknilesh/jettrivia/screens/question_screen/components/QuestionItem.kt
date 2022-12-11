package com.asknilesh.jettrivia.screens.question_screen.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.asknilesh.jettrivia.data.Question
import com.asknilesh.jettrivia.ui.theme.Green
import com.asknilesh.jettrivia.ui.theme.Red
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BuildQuestionItem(
  question: Question,
  onAnswerSelected: () -> Unit = {}
) {
  Log.d("QUESTION ", "ANSWER: ${question.correct_answer}")
  val coroutineScope = rememberCoroutineScope()

  val answerList = question.incorrect_answers + listOf(question.correct_answer)
  val choices = remember {
    mutableStateListOf<String>()
  }
  choices.clear()
  choices.addAll(answerList.shuffled())

  val answerState = remember(question) {
    mutableStateOf<Int?>(null)

  }
  val correctAnswerState = remember(question) {
    mutableStateOf<Boolean?>(null)
  }

  val updateAnswer: (Int) -> Unit = remember(question) {
    {
      answerState.value = it
      correctAnswerState.value = choices[it] == question.correct_answer
    }
  }

  Card(
    modifier = Modifier
      .fillMaxWidth(),
    colors = CardDefaults.cardColors(Color.Transparent)
  ) {
    Text(
      text = question.question, style = MaterialTheme.typography.bodyLarge,
      modifier = Modifier.padding(10.dp)
    )

    LazyColumn(modifier = Modifier.fillMaxWidth()) {
      itemsIndexed(choices) { index, answer ->
        Box(
          modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .clickable {
              updateAnswer(index)
              coroutineScope.launch {
                delay(500)
                onAnswerSelected()
              }
            },

          ) {
          Text(
            text = answer,
            modifier = Modifier
              .fillMaxWidth()
              .background(
                if (correctAnswerState.value == true && index == answerState.value) {
                  question.result = true
                  question.selectedAnswer = answer
                  Green
                } else if (correctAnswerState.value == false && index == answerState.value) {
                  question.result = false
                  question.selectedAnswer = answer
                  Red
                } else {
                  Color.White
                }
              )
              .padding(15.dp)
          )
        }
      }
    }

  }
}