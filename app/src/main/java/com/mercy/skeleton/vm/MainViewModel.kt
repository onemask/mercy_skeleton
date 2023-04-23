package com.mercy.skeleton.vm

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mercy.skeleton.data.Response
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json

class MainViewModel : ViewModel() {
  fun getDog() {
    viewModelScope.launch {
      val json = Json {
        prettyPrint = true
        isLenient = true
      }
      val client = HttpClient(CIO) {
        install(ContentNegotiation) {
          json(json)
        }
      }
      val respone = client.get("https://dog.ceo/api/breeds/image/random")
      Log.d("!! resonpose", "${respone.body<Response>()}")
    }
  }
}
