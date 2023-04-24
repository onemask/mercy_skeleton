package com.mercy.skeleton.data.repository

import com.mercy.skeleton.data.Response
import com.mercy.skeleton.data.api.NetworkApiService
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val apiService: NetworkApiService) : Repository {
  override suspend fun getDog(): Response = apiService.getDog()
}

interface Repository {
  suspend fun getDog(): Response
}