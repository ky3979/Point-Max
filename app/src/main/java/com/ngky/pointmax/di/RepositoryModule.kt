package com.ngky.pointmax.di

import com.ngky.pointmax.data.repository.LocalCentPerPointCalculationRepository
import com.ngky.pointmax.domain.repository.CentPerPointCalculationRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
  @Binds
  abstract fun bindCentPerPointCalculationRepository(
    repository: LocalCentPerPointCalculationRepository
  ): CentPerPointCalculationRepository
}
