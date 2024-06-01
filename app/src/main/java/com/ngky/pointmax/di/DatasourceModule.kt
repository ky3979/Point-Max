package com.ngky.pointmax.di

import com.ngky.pointmax.data.database.datasource.implementations.LocalCentPerPointCalculationDataSource
import com.ngky.pointmax.data.database.datasource.interfaces.CentPerPointCalculationDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DatasourceModule {
  @Binds
  abstract fun bindCentPerPointCalculationDataSource(
    dataSource: LocalCentPerPointCalculationDataSource
  ): CentPerPointCalculationDataSource
}
