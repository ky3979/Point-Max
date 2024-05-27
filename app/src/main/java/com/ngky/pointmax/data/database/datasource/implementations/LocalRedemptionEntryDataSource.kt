package com.ngky.pointmax.data.database.datasource.implementations

import androidx.annotation.WorkerThread
import androidx.room.withTransaction
import com.ngky.pointmax.data.database.AppDatabase
import com.ngky.pointmax.data.database.datasource.interfaces.RedemptionEntryDataSource
import com.ngky.pointmax.data.database.details.RedemptionEntryDetails
import com.ngky.pointmax.data.database.entity.RedemptionEntryEntity
import com.ngky.pointmax.data.database.entity.TransferPartnerCostEntity
import com.ngky.pointmax.data.database.entity.TravelPortalCostEntity
import com.ngky.pointmax.domain.model.TravelPortalCompany
import kotlinx.coroutines.flow.Flow

class LocalRedemptionEntryDataSource(
  private val appDatabase: AppDatabase
) : RedemptionEntryDataSource {

  private val redemptionEntryDao = appDatabase.redemptionEntryDao()
  private val travelPortalCostDao = appDatabase.travelPortalCostDao()
  private val transferPartnerCostDao = appDatabase.transferPartnerCostDao()

  override fun getRedemptionEntryListFlow(): Flow<List<RedemptionEntryDetails>> {
    return redemptionEntryDao.getDetailsListFlow()
  }

  @WorkerThread
  override suspend fun deleteRedemptionEntry(entryId: Long) {
    redemptionEntryDao.deleteById(entryId)
  }

  @WorkerThread
  override suspend fun saveRedemptionEntry(
    title: String,
    cashPrice: Double,
    travelPortalPoints: Int,
    travelPortalCompany: TravelPortalCompany,
    transferPartnerPoints: Int,
    transferPartnerTaxesAndFees: Double,
    transferPartnerBonus: Float
  ) {
    appDatabase.withTransaction {
      val entryEntity = RedemptionEntryEntity(title = title, cashPrice = cashPrice)
      val entryId = redemptionEntryDao.insert(entryEntity)

      val portalCostEntity = TravelPortalCostEntity(
        entryId = entryId,
        points = travelPortalPoints,
        company = travelPortalCompany
      )
      travelPortalCostDao.insert(portalCostEntity)

      val partnerCostEntity = TransferPartnerCostEntity(
        entryId = entryId,
        points = transferPartnerPoints,
        taxesAndFees = transferPartnerTaxesAndFees,
        transferBonus = transferPartnerBonus
      )
      transferPartnerCostDao.insert(partnerCostEntity)
    }
  }
}
