package com.ngky.pointmax.domain.repository

import androidx.annotation.WorkerThread
import com.ngky.pointmax.domain.model.CentPerPointCalculation
import com.ngky.pointmax.domain.model.TravelPortalCompany
import com.ngky.pointmax.domain.model.error.DataSourceError
import kotlinx.coroutines.flow.Flow

interface CentPerPointCalculationRepository {
  fun getCalculationListFlow(): Flow<List<CentPerPointCalculation>>

  @WorkerThread
  @Throws(DataSourceError::class)
  suspend fun deleteCalculation(entry: CentPerPointCalculation)

  @WorkerThread
  @Throws(DataSourceError::class)
  suspend fun saveCalculation(
    title: String,
    cashPrice: Double,
    travelPortalPoints: Int,
    travelPortalCompany: TravelPortalCompany,
    transferPartnerPoints: Int,
    transferPartnerTaxesAndFees: Double,
    transferPartnerBonus: Float
  )
}
