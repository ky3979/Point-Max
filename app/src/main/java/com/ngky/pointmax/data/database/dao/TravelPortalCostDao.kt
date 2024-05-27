package com.ngky.pointmax.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.ngky.pointmax.data.database.entity.TravelPortalCostEntity

@Dao
interface TravelPortalCostDao {
  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun insert(cost: TravelPortalCostEntity): Long
}
