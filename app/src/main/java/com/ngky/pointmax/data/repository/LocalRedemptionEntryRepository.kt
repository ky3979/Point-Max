package com.ngky.pointmax.data.repository

import androidx.annotation.WorkerThread
import com.ngky.pointmax.data.database.datasource.interfaces.RedemptionEntryDataSource
import com.ngky.pointmax.domain.model.RedemptionEntry
import com.ngky.pointmax.domain.model.TravelPortalCompany
import com.ngky.pointmax.domain.model.error.DataSourceError
import com.ngky.pointmax.domain.repository.RedemptionEntryRepository
import com.ngky.pointmax.ext.safeDatabaseCall
import com.ngky.pointmax.ext.safeFlow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LocalRedemptionEntryRepository(
  private val dataSource: RedemptionEntryDataSource
) : RedemptionEntryRepository {
  override fun getRedemptionEntryListFlow(): Flow<List<RedemptionEntry>> {
    return dataSource.getRedemptionEntryListFlow()
      .map { entries -> entries.map { entry -> entry.toDomainModel() } }
      .safeFlow()
  }

  @WorkerThread
  @Throws(DataSourceError::class)
  override suspend fun deleteRedemptionEntry(entry: RedemptionEntry) = safeDatabaseCall {
    dataSource.deleteRedemptionEntry(entry.id)
  }

  @WorkerThread
  @Throws(DataSourceError::class)
  override suspend fun saveRedemptionEntry(
    title: String,
    cashPrice: Double,
    travelPortalPoints: Int,
    travelPortalCompany: TravelPortalCompany,
    transferPartnerPoints: Int,
    transferPartnerTaxesAndFees: Double,
    transferPartnerBonus: Float
  ) = safeDatabaseCall {
    dataSource.saveRedemptionEntry(
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
