package com.asknilesh.jettrivia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.asknilesh.jettrivia.navigations.AppNavigation
import com.asknilesh.jettrivia.ui.theme.JetTriviaTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      MyApp()
    }
  }

  @Composable fun MyApp() {
    JetTriviaTheme {
      AppNavigation()
    }
  }
}

