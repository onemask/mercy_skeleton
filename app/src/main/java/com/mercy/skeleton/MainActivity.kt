package com.mercy.skeleton

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mercy.skeleton.ui.theme.EndOnBoardingScreen
import com.mercy.skeleton.ui.theme.MercySkeletonTheme
import com.mercy.skeleton.ui.theme.OnBoardingScreen
import com.mercy.skeleton.ui.theme.StartOnBoardingScreen
import com.mercy.skeleton.vm.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      MercyApp()
    }
  }

  @Composable
  fun MercyApp() {
    MercySkeletonTheme {
      val navController = rememberNavController()
      Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
        NavHost(
          navController = navController,
          startDestination = OnBoardingScreen.Start.route
        ) {
          val viewModel by viewModels<MainViewModel>()
          composable(route = OnBoardingScreen.Start.route) {
            StartOnBoardingScreen(
              viewModel = viewModel,
              contents = "I'm not superstitious, but I am a little stitious",
              onClickNextButton = {
                navController.navigate(OnBoardingScreen.END.route)
              }
            )
          }
          composable(route = OnBoardingScreen.END.route) {
            EndOnBoardingScreen(
              contents = "end"
            )
          }
        }
      }
    }
  }

}