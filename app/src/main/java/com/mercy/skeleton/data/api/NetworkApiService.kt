package com.mercy.skeleton.data.api

import com.mercy.skeleton.data.Response
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.accept
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json

class NetworkApiService {
  companion object {
    const val BASE_URL = "https://dog.ceo/api"
  }

  @OptIn(ExperimentalSerializationApi::class)
  private val json: Json = Json {
    prettyPrint = true
    isLenient = true
    ignoreUnknownKeys = true
    explicitNulls = true
  }
  private val client: HttpClient = HttpClient(CIO) {
    install(ContentNegotiation) {
      json(json)
    }
  }

  suspend fun getDog() = client.get("$BASE_URL/breeds/image/random") {
    accept(ContentType.Application.Json)
  }.body<Response>()
}