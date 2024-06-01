package com.ngky.pointmax.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.ngky.pointmax.data.database.details.CentPerPointCalculationDetails
import com.ngky.pointmax.data.database.entity.CentPerPointCalculationEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CentPerPointCalculationDao {
  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun insert(entry: CentPerPointCalculationEntity): Long

  @Transaction
  @Query("SELECT * FROM CentPerPointCalculation")
  fun getDetailsListFlow(): Flow<List<CentPerPointCalculationDetails>>

  @Query("DELETE FROM CentPerPointCalculation WHERE id = :id")
  suspend fun deleteById(id: Long): Int
}
