package com.asknilesh.jettrivia.screens.result_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.asknilesh.jettrivia.data.Question
import com.asknilesh.jettrivia.ui.theme.Green
import com.asknilesh.jettrivia.ui.theme.Red

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BuildResultCardView(question: Question) {
  Card(
    modifier = Modifier
      .fillMaxWidth()
      .padding(10.dp),
    colors = CardDefaults.cardColors(Color.White),
    shape = RoundedCornerShape(2.dp),
    elevation = CardDefaults.cardElevation(5.dp),
  ) {
    Column(modifier = Modifier.fillMaxWidth()) {
      Text(
        text = question.question, style = MaterialTheme.typography.bodyLarge,
        modifier = Modifier.padding(10.dp)
      )

      Text(
        modifier = Modifier.padding(10.dp),
        text = buildAnnotatedString {
        withStyle(
          style = SpanStyle(
            fontWeight = FontWeight.Normal, fontSize = 16.sp,
            color = Color.LightGray
          ),
        ) {
          append("Correct answer:")
          append(" ")
        }
        withStyle(
          style = SpanStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
          ),
        ) {
          append(question.correct_answer)
        }

      })


      Text(
        text = question.selectedAnswer,
        modifier = Modifier
          .fillMaxWidth()
          .padding(vertical = 10.dp)
          .background(
            if (question.result && question.selectedAnswer.isNotEmpty()) {
              Green
            } else if (!question.result && question.selectedAnswer.isNotEmpty()) {
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