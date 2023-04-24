package com.mercy.skeleton

import android.graphics.drawable.VectorDrawable
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.mercy.skeleton.ui.theme.MercySkeletonTheme
import com.mercy.skeleton.vm.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      MercySkeletonTheme {
        val viewModel by viewModels<MainViewModel>()
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
          val dogImage by viewModel.dogImage.collectAsState()
          dogImage?.let {
            OnBoardingScreen(
              image = it,
              "I'm not superstitious, but I am a little stitious"
            )
          }
        }
      }
    }
  }
}

@Composable
fun OnBoardingScreen(image: String, contents: String) {
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
      model = image,
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
    OnBoardingScreen("Android", "I'm not superstitious, but I am a little stitious")
  }
}