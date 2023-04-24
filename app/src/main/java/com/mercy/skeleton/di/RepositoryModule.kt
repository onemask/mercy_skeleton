package com.mercy.skeleton.di

import com.mercy.skeleton.data.repository.Repository
import com.mercy.skeleton.data.repository.RepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
  @Binds
  abstract fun bindRepository(repository: RepositoryImpl): Repository
}