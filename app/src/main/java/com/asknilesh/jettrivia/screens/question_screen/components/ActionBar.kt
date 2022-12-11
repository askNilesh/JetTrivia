package com.asknilesh.jettrivia.screens.question_screen.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.asknilesh.jettrivia.ui.theme.Purple80
import com.asknilesh.jettrivia.ui.theme.Red

@Preview
@Composable
fun CenterTopBar(
  title: String = "Dummy title",
  isLoading: MutableState<Boolean> = mutableStateOf(false),
  onRefreshClick: () -> Unit = {}
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
    actions = {
      IconButton(onClick = { onRefreshClick() }) {
        if (isLoading.value) {
          Box(contentAlignment = Alignment.Center) {
            CircularProgressIndicator(
              color = Red,
              modifier = Modifier.then(Modifier.size(30.dp)))

            CircularProgressIndicator(
              color = Blue,
              modifier = Modifier.then(Modifier.size(40.dp)))
          }
        } else {
          Icon(
            imageVector = Icons.Default.Refresh,
            tint = Color.White,
            contentDescription = "Refresh"
          )
        }

      }
    }

  )
}