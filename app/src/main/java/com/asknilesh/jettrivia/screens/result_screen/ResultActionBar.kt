package com.asknilesh.jettrivia.screens.result_screen

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.asknilesh.jettrivia.ui.theme.Purple80

@Preview
@Composable
fun CenterTopBar(
  title: String = "Dummy title",
) {
  CenterAlignedTopAppBar(
    title = {
      Text(
        text = title,
        style = MaterialTheme.typography.titleLarge,
        color = Color.White,
        fontWeight = FontWeight.Bold,
      )
    },
    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Purple80),

  )
}