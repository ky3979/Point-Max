package com.ngky.pointmax.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ngky.pointmax.data.database.dao.RedemptionEntryDao
import com.ngky.pointmax.data.database.dao.TransferPartnerCostDao
import com.ngky.pointmax.data.database.dao.TravelPortalCostDao
import com.ngky.pointmax.data.database.entity.RedemptionEntryEntity
import com.ngky.pointmax.data.database.entity.TransferPartnerCostEntity
import com.ngky.pointmax.data.database.entity.TravelPortalCostEntity
import com.ngky.pointmax.domain.model.RedemptionEntry

@Database(
  version = 1,
  entities = [
    RedemptionEntryEntity::class,
    TravelPortalCostEntity::class,
    TransferPartnerCostEntity::class
  ]
)
abstract class AppDatabase : RoomDatabase() {
  companion object {
    const val DATABASE_NAME = "pointmax_db"
  }

  abstract fun redemptionEntryDao(): RedemptionEntryDao
  abstract fun travelPortalCostDao(): TravelPortalCostDao
  abstract fun transferPartnerCostDao(): TransferPartnerCostDao
}
