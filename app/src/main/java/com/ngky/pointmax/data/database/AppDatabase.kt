package com.ngky.pointmax.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ngky.pointmax.data.database.dao.CentPerPointCalculationDao
import com.ngky.pointmax.data.database.dao.TransferPartnerCostDao
import com.ngky.pointmax.data.database.dao.TravelPortalCostDao
import com.ngky.pointmax.data.database.entity.CentPerPointCalculationEntity
import com.ngky.pointmax.data.database.entity.TransferPartnerCostEntity
import com.ngky.pointmax.data.database.entity.TravelPortalCostEntity

@Database(
  version = 1,
  entities = [
    CentPerPointCalculationEntity::class,
    TravelPortalCostEntity::class,
    TransferPartnerCostEntity::class
  ]
)
abstract class AppDatabase : RoomDatabase() {
  companion object {
    const val DATABASE_NAME = "pointmax_db"
  }

  abstract fun centPerPointCalculationDao(): CentPerPointCalculationDao
  abstract fun travelPortalCostDao(): TravelPortalCostDao
  abstract fun transferPartnerCostDao(): TransferPartnerCostDao
}
