package com.ngky.pointmax.data.database.datasource.interfaces

import androidx.annotation.WorkerThread
import com.ngky.pointmax.data.database.details.RedemptionEntryDetails
import com.ngky.pointmax.domain.model.TravelPortalCompany
import kotlinx.coroutines.flow.Flow

interface RedemptionEntryDataSource {
  fun getRedemptionEntryListFlow(): Flow<List<RedemptionEntryDetails>>

  @WorkerThread
  suspend fun deleteRedemptionEntry(entryId: Long)

  @WorkerThread
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
