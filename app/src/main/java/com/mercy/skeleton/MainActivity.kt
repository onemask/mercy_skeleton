package com.mercy.skeleton

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.mercy.skeleton.ui.theme.MercySkeletonTheme
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
  private fun MercyApp() {
    MercySkeletonTheme {
      val navController = rememberNavController()
      Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
        NavHost(navController = navController, startDestination = OnBoardingScreen.Start.name) {
          composable(route = OnBoardingScreen.Start.name) {
            val viewModel by viewModels<MainViewModel>()
            StartOnBoardingScreen(
              viewModel = viewModel,
              contents = "I'm not superstitious, but I am a little stitious",
              onClickNextButton = {
                navController.navigate(OnBoardingScreen.END.name)
              }
            )
          }
          composable(route = OnBoardingScreen.END.name) {
            EndnBoardingScreen(
              contents = "I'm not superstitious, but I am a little stitious"
            )
          }
        }
      }
    }
  }

  enum class OnBoardingScreen(name: String) {
    Start(name = "start"),
    END(name = "end")
  }

  @Composable
  fun StartOnBoardingScreen(
    viewModel: MainViewModel = viewModel(),
    contents: String,
    onClickNextButton: () -> Unit,
  ) {
    val dogImage by viewModel.dogImage.collectAsState()
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 12.dp)
    ) {
      Text(
        modifier = Modifier
          .fillMaxWidth()
          .padding(top = 120.dp),
        text = "OnBoarding",
        style = MaterialTheme.typography.headlineLarge,
        textAlign = TextAlign.Center
      )
      Text(
        text = contents,
        modifier = Modifier
          .fillMaxWidth()
          .padding(top = 10.dp),
        textAlign = TextAlign.Center
      )
      AsyncImage(
        model = dogImage,
        modifier = Modifier
          .padding(vertical = 10.dp)
          .fillMaxWidth()
          .clip(RoundedCornerShape(12.dp)),
        placeholder = painterResource(id = R.drawable.images_mode),
        contentDescription = null,
      )
      Button(
        onClick = { onClickNextButton() },
        modifier = Modifier
          .fillMaxWidth()
          .background(
            color = MaterialTheme.colorScheme.primary,
            shape = RoundedCornerShape(12.dp)
          )
          .padding(vertical = 4.dp)
      ) {
        Text(text = "Next")
      }
    }
  }

  @Composable
  fun EndnBoardingScreen(
    contents: String = "end",
  ) {
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 12.dp)
    ) {
      Text(
        modifier = Modifier
          .fillMaxWidth()
          .padding(top = 120.dp),
        text = "end",
        style = MaterialTheme.typography.headlineLarge,
        textAlign = TextAlign.Center
      )
      Text(
        text = contents,
        modifier = Modifier
          .fillMaxWidth()
          .padding(top = 10.dp),
        textAlign = TextAlign.Center
      )
      AsyncImage(
        model = "https://images.dog.ceo/breeds/terrier-norwich/n02094258_100.jpg",
        modifier = Modifier
          .padding(vertical = 10.dp)
          .fillMaxWidth()
          .clip(RoundedCornerShape(12.dp)),
        placeholder = painterResource(id = R.drawable.images_mode),
        contentDescription = null,
      )
      Button(
        onClick = { /*TODO*/ },
        modifier = Modifier
          .fillMaxWidth()
          .background(
            color = MaterialTheme.colorScheme.primary,
            shape = RoundedCornerShape(12.dp)
          )
          .padding(vertical = 4.dp)
      ) {
        Text(text = "Next")
      }
    }
  }


  @Preview(showBackground = true)
  @Composable
  fun GreetingPreview() {
    MercySkeletonTheme {
      StartOnBoardingScreen(
        contents = "I'm not superstitious, but I am a little stitious",
        onClickNextButton = {}
      )
    }
  }
}