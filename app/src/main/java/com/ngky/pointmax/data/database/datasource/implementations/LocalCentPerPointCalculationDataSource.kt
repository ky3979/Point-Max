package com.ngky.pointmax.data.database.datasource.implementations

import androidx.annotation.WorkerThread
import androidx.room.withTransaction
import com.ngky.pointmax.data.database.AppDatabase
import com.ngky.pointmax.data.database.datasource.interfaces.CentPerPointCalculationDataSource
import com.ngky.pointmax.data.database.details.CentPerPointCalculationDetails
import com.ngky.pointmax.data.database.entity.CentPerPointCalculationEntity
import com.ngky.pointmax.data.database.entity.TransferPartnerCostEntity
import com.ngky.pointmax.data.database.entity.TravelPortalCostEntity
import com.ngky.pointmax.domain.model.TravelPortalCompany
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalCentPerPointCalculationDataSource @Inject constructor(
  private val appDatabase: AppDatabase
) : CentPerPointCalculationDataSource {

  private val centPerPointCalculationDao = appDatabase.centPerPointCalculationDao()
  private val travelPortalCostDao = appDatabase.travelPortalCostDao()
  private val transferPartnerCostDao = appDatabase.transferPartnerCostDao()

  override fun getCentPerPointCalculationListFlow(): Flow<List<CentPerPointCalculationDetails>> {
    return centPerPointCalculationDao.getDetailsListFlow()
  }

  @WorkerThread
  override suspend fun deleteCentPerPointCalculationEntry(entryId: Long) {
    centPerPointCalculationDao.deleteById(entryId)
  }

  @WorkerThread
  override suspend fun saveCentPerPointCalculation(
    title: String,
    cashPrice: Double,
    travelPortalPoints: Int,
    travelPortalCompany: TravelPortalCompany,
    transferPartnerPoints: Int,
    transferPartnerTaxesAndFees: Double,
    transferPartnerBonus: Float
  ) {
    appDatabase.withTransaction {
      val entryEntity = CentPerPointCalculationEntity(title = title, cashPrice = cashPrice)
      val entryId = centPerPointCalculationDao.insert(entryEntity)

      val portalCostEntity = TravelPortalCostEntity(
        calculationId = entryId,
        points = travelPortalPoints,
        company = travelPortalCompany
      )
      travelPortalCostDao.insert(portalCostEntity)

      val partnerCostEntity = TransferPartnerCostEntity(
        calculationId = entryId,
        points = transferPartnerPoints,
        taxesAndFees = transferPartnerTaxesAndFees,
        transferBonus = transferPartnerBonus
      )
      transferPartnerCostDao.insert(partnerCostEntity)
    }
  }
}
