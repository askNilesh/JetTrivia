package com.asknilesh.jettrivia.screens.question_screen

import android.annotation.SuppressLint
import android.net.Uri
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.asknilesh.jettrivia.data.QuestionData
import com.asknilesh.jettrivia.navigations.TriviaScreens
import com.asknilesh.jettrivia.screens.question_screen.components.BuildQuestionHeader
import com.asknilesh.jettrivia.screens.question_screen.components.BuildQuestionItem
import com.asknilesh.jettrivia.screens.question_screen.components.CenterTopBar
import com.asknilesh.jettrivia.ui.theme.Purple500
import com.asknilesh.jettrivia.ui.theme.PurpleGrey40
import com.asknilesh.jettrivia.viewmodel.QuestionViewModel
import com.google.gson.Gson
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BuildQuestionListScreen(
  navController: NavController,
  questionViewModel: QuestionViewModel = hiltViewModel(),

  ) {
  val loadingState = remember {
    questionViewModel.showLoading
  }
  val questionList = remember {
    questionViewModel.questionList
  }

  val coroutineScope = rememberCoroutineScope()

  coroutineScope.launch {
    questionViewModel.getQuestions()
  }

  val currentQuestion = remember {
    mutableStateOf(0)
  }
  Scaffold(
    topBar = {
      CenterTopBar(
        title = "JetTrivia",
        isLoading = loadingState
      ) {
        coroutineScope.launch {
          questionViewModel.getQuestions()
        }
      }
    },
  ) { paddingValues ->

    Column(
      modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .background(PurpleGrey40)
        .padding(paddingValues)
    ) {
      if (questionList.isNotEmpty()) {

        BuildQuestionHeader(currentQuestion = currentQuestion, questionList.size)

        Spacer(modifier = Modifier.height(20.dp))
        BuildQuestionItem(
          question = questionList[currentQuestion.value],
        ) {
          questionList.forEach {
            Log.d("ANSWER_STATE", "BuildQuestionScreen: ${it.result}")
          }
          val next = currentQuestion.value + 1
          if (next < questionList.size) {
            currentQuestion.value = next
          }
        }

        Button(
          onClick = {
            if (currentQuestion.value == questionList.size - 1) {
              val questionData = QuestionData(questionList)
              val json = Uri.encode(Gson().toJson(questionData))
              navController.navigate(TriviaScreens.RESULT_SCREEN.name + "/${json}")
            } else {
              val next = currentQuestion.value + 1
              if (next < questionList.size) {
                currentQuestion.value = next
              }
            }
          },
          colors = ButtonDefaults.buttonColors(containerColor = Purple500),
          shape = RoundedCornerShape(5.dp),
          modifier = Modifier
            .align(alignment = Alignment.CenterHorizontally)
            .padding(horizontal = 20.dp)
        ) {
          Text(text = if (currentQuestion.value == questionList.size - 1) "Show Result" else "Skip")
        }
      }

    }

  }
}