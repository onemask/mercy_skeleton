package com.mercy.skeleton

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mercy.skeleton.ui.theme.MercySkeletonTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      MercySkeletonTheme {
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
          OnBoardingScreen("I'm not superstitious, but I am a little stitious")
        }
      }
    }
  }
}

@Composable
fun OnBoardingScreen(contents: String) {
  Column(
    modifier = Modifier
      .fillMaxWidth()
      .padding(horizontal = 32.dp)
  ) {
    Text(
      modifier = Modifier
        .fillMaxWidth()
        .padding(top = 120.dp),
      text = "OnBoarding",
      style = MaterialTheme.typography.headlineLarge,
      textAlign = TextAlign.Center
    )
    Text(text = contents, modifier = Modifier.padding(top = 10.dp), textAlign = TextAlign.Center)
    Image(
      painter = painterResource(id = R.drawable.ic_launcher_background),
      contentDescription = null
    )
  }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
  MercySkeletonTheme {
    OnBoardingScreen("Android")
  }
}