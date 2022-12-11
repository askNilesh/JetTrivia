package com.asknilesh.jettrivia.screens.question_screen.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.unit.dp

@Composable
fun DrawDottedLine() {
  Canvas(
    modifier = Modifier
      .fillMaxWidth()
      .height(2.dp)
  ) {
    drawLine(
      color = Color.Black, start = Offset(0f, 0f), end = Offset(size.width, 0f),
      pathEffect = PathEffect.dashPathEffect(intervals = floatArrayOf(10f, 10f), 0f)
    )
  }
}