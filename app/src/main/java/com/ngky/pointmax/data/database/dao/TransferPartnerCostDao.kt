package com.ngky.pointmax.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.ngky.pointmax.data.database.entity.TransferPartnerCostEntity

@Dao
interface TransferPartnerCostDao {
  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun insert(cost: TransferPartnerCostEntity): Long
}
