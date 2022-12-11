package com.asknilesh.jettrivia.screens.result_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.asknilesh.jettrivia.data.QuestionData

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BuildResultScreen(navController: NavController, questionData: QuestionData?) {

  val resultList = remember {
    questionData?.question?.toMutableList()
  }
  val correctAnswer = remember {
    resultList?.filter { it.result }?.size ?: 0
  }


  Scaffold(
    topBar = {
      CenterTopBar(title = "Result ${correctAnswer}/${resultList?.size}")
    }
  ) { paddingValues ->
    Column(modifier = Modifier.padding(paddingValues)) {
      resultList?.let {
        LazyColumn {
          items(it) { item ->
            BuildResultCardView(question = item)
          }
        }

      }
    }

  }
}
