package com.mercy.skeleton.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
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
import coil.compose.AsyncImage
import com.mercy.skeleton.R
import com.mercy.skeleton.vm.MainViewModel

enum class OnBoardingScreen(val route: String) {
  Start(route = "start"),
  END(route = "end")
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
fun EndOnBoardingScreen(contents: String) {
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


