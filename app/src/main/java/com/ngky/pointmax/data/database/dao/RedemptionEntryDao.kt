package com.ngky.pointmax.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.ngky.pointmax.data.database.details.RedemptionEntryDetails
import com.ngky.pointmax.data.database.entity.RedemptionEntryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface RedemptionEntryDao {
  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun insert(entry: RedemptionEntryEntity): Long

  @Transaction
  @Query("SELECT * FROM RedemptionEntry")
  fun getDetailsListFlow(): Flow<List<RedemptionEntryDetails>>

  @Query("DELETE FROM RedemptionEntry WHERE id = :id")
  suspend fun deleteById(id: Long): Int
}
