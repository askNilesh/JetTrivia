package com.asknilesh.jettrivia.screens.question_screen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
@Preview
fun BuildQuestionHeader(
  currentQuestion: MutableState<Int> = mutableStateOf(10),
  totalQuestion: Int = 100,
) {
  Column(modifier = Modifier.fillMaxWidth()) {
    Text(
      modifier = Modifier
        .fillMaxWidth()
        .padding(top = 20.dp, bottom = 10.dp),
      text = buildAnnotatedString {
        withStyle(
          style = SpanStyle(
            fontWeight = FontWeight.Bold,
            color = Color.White,
            fontSize = 22.sp
          )
        ) {
          append("Question ${currentQuestion.value + 1}/")
        }
        withStyle(
          style = SpanStyle(
            fontWeight = FontWeight.Normal,
            color = Color.Gray,
            fontSize = 16.sp
          )
        ) {
          append("$totalQuestion")
        }

      }, textAlign = TextAlign.Center
    )
    Spacer(modifier = Modifier.height(20.dp))
    DrawDottedLine()
  }
}