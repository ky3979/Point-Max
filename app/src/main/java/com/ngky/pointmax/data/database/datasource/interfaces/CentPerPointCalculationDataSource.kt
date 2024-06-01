package com.ngky.pointmax.data.database.datasource.interfaces

import androidx.annotation.WorkerThread
import com.ngky.pointmax.data.database.details.CentPerPointCalculationDetails
import com.ngky.pointmax.domain.model.TravelPortalCompany
import kotlinx.coroutines.flow.Flow

interface CentPerPointCalculationDataSource {
  fun getCentPerPointCalculationListFlow(): Flow<List<CentPerPointCalculationDetails>>

  @WorkerThread
  suspend fun deleteCentPerPointCalculationEntry(entryId: Long)

  @WorkerThread
  suspend fun saveCentPerPointCalculation(
    title: String,
    cashPrice: Double,
    travelPortalPoints: Int,
    travelPortalCompany: TravelPortalCompany,
    transferPartnerPoints: Int,
    transferPartnerTaxesAndFees: Double,
    transferPartnerBonus: Float
  )
}
