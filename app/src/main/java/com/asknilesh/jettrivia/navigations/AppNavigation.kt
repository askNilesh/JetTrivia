package com.asknilesh.jettrivia.navigations

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.asknilesh.jettrivia.data.QuestionData
import com.asknilesh.jettrivia.screens.question_screen.BuildQuestionListScreen
import com.asknilesh.jettrivia.screens.result_screen.BuildResultScreen
import com.asknilesh.jettrivia.utils.QuestionParamType
import com.asknilesh.jettrivia.utils.parcelable

@Composable
fun AppNavigation() {
  val navController = rememberNavController()
  NavHost(
    navController = navController, startDestination = TriviaScreens.QUESTION_SCREEN.name,
  ) {
    composable(TriviaScreens.QUESTION_SCREEN.name) {
      BuildQuestionListScreen(navController = navController)
    }

    composable(
      TriviaScreens.RESULT_SCREEN.name + "/{question_result}",
      arguments = listOf(
        navArgument(name = "question_result") {
          type = QuestionParamType()
        }
      )
    ) { backStackEntry ->
      val questionData = backStackEntry.arguments?.parcelable<QuestionData>("question_result")

      BuildResultScreen(navController, questionData)
    }
  }
}