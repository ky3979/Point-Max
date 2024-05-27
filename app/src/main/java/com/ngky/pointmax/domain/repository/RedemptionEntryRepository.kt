package com.ngky.pointmax.domain.repository

import androidx.annotation.WorkerThread
import com.ngky.pointmax.domain.model.RedemptionEntry
import com.ngky.pointmax.domain.model.TravelPortalCompany
import com.ngky.pointmax.domain.model.error.DataSourceError
import kotlinx.coroutines.flow.Flow

interface RedemptionEntryRepository {
  fun getRedemptionEntryListFlow(): Flow<List<RedemptionEntry>>

  @WorkerThread
  @Throws(DataSourceError::class)
  suspend fun deleteRedemptionEntry(entry: RedemptionEntry)

  @WorkerThread
  @Throws(DataSourceError::class)
  suspend fun saveRedemptionEntry(
    title: String,
    cashPrice: Double,
    travelPortalPoints: Int,
    travelPortalCompany: TravelPortalCompany,
    transferPartnerPoints: Int,
    transferPartnerTaxesAndFees: Double,
    transferPartnerBonus: Float
  )
}
