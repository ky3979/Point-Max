package com.ngky.pointmax.data.database.entity

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
  tableName = "RedemptionEntry",
  indices = [Index("id")]
)
data class RedemptionEntryEntity(
  @PrimaryKey(autoGenerate = true)
  val id: Long = 0,
  val title: String,
  val cashPrice: Double
)
