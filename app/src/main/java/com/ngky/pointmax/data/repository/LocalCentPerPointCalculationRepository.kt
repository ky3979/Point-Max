package com.ngky.pointmax.data.repository

import androidx.annotation.WorkerThread
import com.ngky.pointmax.data.database.datasource.interfaces.CentPerPointCalculationDataSource
import com.ngky.pointmax.domain.model.CentPerPointCalculation
import com.ngky.pointmax.domain.model.TravelPortalCompany
import com.ngky.pointmax.domain.model.error.DataSourceError
import com.ngky.pointmax.domain.repository.CentPerPointCalculationRepository
import com.ngky.pointmax.ext.safeDatabaseCall
import com.ngky.pointmax.ext.safeFlow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LocalCentPerPointCalculationRepository @Inject constructor(
  private val dataSource: CentPerPointCalculationDataSource
) : CentPerPointCalculationRepository {
  override fun getCalculationListFlow(): Flow<List<CentPerPointCalculation>> {
    return dataSource.getCentPerPointCalculationListFlow()
      .map { entries -> entries.map { entry -> entry.toDomainModel() } }
      .safeFlow()
  }

  @WorkerThread
  @Throws(DataSourceError::class)
  override suspend fun deleteCalculation(entry: CentPerPointCalculation) = safeDatabaseCall {
    dataSource.deleteCentPerPointCalculationEntry(entry.id)
  }

  @WorkerThread
  @Throws(DataSourceError::class)
  override suspend fun saveCalculation(
    title: String,
    cashPrice: Double,
    travelPortalPoints: Int,
    travelPortalCompany: TravelPortalCompany,
    transferPartnerPoints: Int,
    transferPartnerTaxesAndFees: Double,
    transferPartnerBonus: Float
  ) = safeDatabaseCall {
    dataSource.saveCentPerPointCalculation(
      title = title,
      cashPrice = cashPrice,
      travelPortalPoints = travelPortalPoints,
      travelPortalCompany = travelPortalCompany,
      transferPartnerPoints = transferPartnerPoints,
      transferPartnerTaxesAndFees = transferPartnerTaxesAndFees,
      transferPartnerBonus = transferPartnerBonus
    )
  }
}
