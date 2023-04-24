package com.mercy.skeleton.di

import com.mercy.skeleton.data.api.NetworkApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object ApiModule  {
  @Singleton
  @Provides
  fun provideApiService(): NetworkApiService = NetworkApiService()
}